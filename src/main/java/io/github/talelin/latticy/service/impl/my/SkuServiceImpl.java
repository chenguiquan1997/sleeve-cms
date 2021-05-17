package io.github.talelin.latticy.service.impl.my;

import com.alibaba.fastjson.JSON;
import io.github.talelin.latticy.bo.my.SkuBO;
import io.github.talelin.latticy.bo.my.SpecJsonBO;
import io.github.talelin.latticy.common.exception.SaveException;
import io.github.talelin.latticy.common.exception.UpdateException;
import io.github.talelin.latticy.dto.my.BelongSpec;
import io.github.talelin.latticy.dto.my.SkuSaveDTO;
import io.github.talelin.latticy.dto.my.SkuUpdateDTO;
import io.github.talelin.latticy.mapper.my.SkuMapper;
import io.github.talelin.latticy.mapper.my.SkuSpecMapper;
import io.github.talelin.latticy.mapper.my.SpuMapper;
import io.github.talelin.latticy.model.my.*;
import io.github.talelin.latticy.service.imy.ISkuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class SkuServiceImpl implements ISkuService {

    @Autowired
    private SkuMapper skuMapper;

    @Autowired
    private SpuMapper spuMapper;

    @Autowired
    private SkuSpecMapper skuSpecMapper;

    /**
     * 根据spuid 查询所属Sku
     * @param spuId
     * @return
     */
    @Override
    public List<Sku> searchSkuListBySpuId(Long spuId) {
        return skuMapper.searchSkuListBySpuId(spuId);
    }

    /**
     * @Description: 分页查询sku
     * @param pageMap 分页参数
     * @param size 当前页数据量
     * @return io.github.talelin.latticy.model.my.Page<io.github.talelin.latticy.model.my.Sku>
     * @Author: Guiquan Chen
     * @Date: 2021/3/30
     */
    @Override
    public Page searchSkuListByPage(Map<String,Integer> pageMap, Integer size) {
        Integer count = skuMapper.searchAllSkuCount();
        if(count < 1) {
            return new Page();
        }
        List<SkuSummary> skus = skuMapper.searchSkuListByPage(pageMap.get("startCount"),size);
        Page skuPage = new Page<>(count,skus,pageMap.get("currPage"),size);
        return skuPage;
    }

    /**
     * @Description: 分页查询指定Spu下的sku列表
     * @param pageMap 分页参数
     * @param size 当前页数据量
     * @param spuId spu id
     * @return io.github.talelin.latticy.model.my.Page
     * @Author: Guiquan Chen
     * @Date: 2021/5/4
     */
    @Override
    public Page searchSkuListBySpuId(Map<String, Integer> pageMap, Integer size, Long spuId) {
        Integer count = skuMapper.searchAllSkuCountWithSpu(spuId);
        if(count < 1) {
            return new Page();
        }
        List<SkuSummary> skus = skuMapper.searchSkuListBySpu(pageMap.get("startCount"),size,spuId);
        Page skuPage = new Page<>(count,skus,pageMap.get("currPage"),size);
        return skuPage;
    }

    /**
     * @Description: 获取指定sku详情
     * @param skuId
     * @return io.github.talelin.latticy.bo.my.SkuBO
     * @Author: Guiquan Chen
     * @Date: 2021/4/12
     */
    @Override
    public SkuBO searchSkuDetailBySkuId(Long skuId) {
        SkuBO skuBO = new SkuBO();
        Sku sku = skuMapper.selectById(skuId);
        if(sku == null) {
            log.error("当前SKU不存在，skuId=[{}]",skuId);
            throw new NotFoundException(25001);
        }
        BeanUtils.copyProperties(sku,skuBO);
        Long spuId = sku.getSpuId();
        // 获取SPU名称
        Spu spu = spuMapper.selectById(spuId);
        if(spu == null) {
            log.error("无法获取到当前SKU的所属SPU，skuId=[{}]，spuId=[{}]",skuId,spuId);
            throw new NotFoundException(25002);
        }
        skuBO.setBelongSpu(spu.getTitle());
        // 获取SKU所拥有的规格
        List<SkuSpec> skuSpecs = skuSpecMapper.searchSkuSpecBySkuId(skuId);
        if(skuSpecs == null || skuSpecs.size() < 1) {
            log.error("无法获取到当前SKU的规格，skuId=[{}]",skuId);
            throw new NotFoundException(25002);
        }
        skuBO.setSkuSpecs(skuSpecs);
        return skuBO;
    }

    /**
     * @Description: 更新 sku 信息
     * @param skuUpdateDTO
     * @Author: Guiquan Chen
     * @Date: 2021/4/27
     * 在使用Spring的事务时，如果我们在内部捕获了异常，那么事务就会忽略这个异常，不会进行数据库的回滚操作
     * 如果我们需要保证多个对数据库的操作，失败时进行回滚，那么在捕获了事务后，还需要抛出一个自定义异常
     */
    @Override
    @Transactional
    public void update(SkuUpdateDTO skuUpdateDTO) {
        // 先将规格转换为 json 格式
        List<SpecJsonBO> specJsons = SpecJsonBO.convert(skuUpdateDTO.getBelongSpecs());
        String jsonSpecs = JSON.toJSONString(specJsons);
        // DTO 对象和 DO 对象进行转换
        Sku sku = new Sku();
        BeanUtils.copyProperties(skuUpdateDTO,sku);
        sku.setSpecs(jsonSpecs);
        try {
            skuMapper.updateById(sku);
        } catch (Exception  e) {
            log.error("更新sku数据发生错误, skuId=[{}]",skuUpdateDTO.getId(),e);
            throw new UpdateException(25003);
        }
        // 需要更新 sku-spec 表，先删除再添加
        skuSpecMapper.removeSpecBySkuId(skuUpdateDTO.getId());
        log.info("成功删除当前SKU规格，skuId=[{}]",skuUpdateDTO.getId());
        List<SkuSpec> skuSpecs = SkuSpec.convert(skuUpdateDTO.getBelongSpecs(),skuUpdateDTO.getId(),skuUpdateDTO.getSpuId());
        skuSpecMapper.addSkuSpecs(skuSpecs);
        log.info("成功添加当前SKU规格，skuId=[{}]",skuUpdateDTO.getId());
        log.info("成功更新SKU信息，skuId=[{}]",skuUpdateDTO.getId());
    }

    /**
     * @Description: 创建 SKU
     * @param skuSaveDTO
     * @return:
     * @Author: Guiquan Chen
     * @Date: 2021/5/3
     */
    @Transactional
    @Override
    public void save(SkuSaveDTO skuSaveDTO) {
        Sku sku = new Sku();
        BeanUtils.copyProperties(skuSaveDTO,sku);
        String skuCode = this.buildCode(skuSaveDTO.getSpuId(),skuSaveDTO.getBelongSpecs());
        sku.setCode(skuCode);
        // 将规格转换为 json 格式
        List<SpecJsonBO> specJsons = SpecJsonBO.convert(skuSaveDTO.getBelongSpecs());
        String jsonSpecs = JSON.toJSONString(specJsons);
        sku.setSpecs(jsonSpecs);
        // 需要向sku实体对象中添加 category_id 和 root_category_id
        Spu spu = spuMapper.selectById(skuSaveDTO.getSpuId());
        sku.setCategoryId(spu.getCategoryId());
        sku.setRootCategoryId(spu.getRootCategoryId());
        Long id = -1L;
        try {
            // 插入 sku 数据
            skuMapper.insert(sku);
            id = sku.getId();
            log.info("成功添加 SKU 数据到 sku 表，skuId=[{}]",id);
        }catch (Exception e) {
            log.error("添加 SKU 数据到 sku 表失败, skuId=[{}]",id,e);
            throw new SaveException(25004);
        }
        // 将 sku 所拥有的规格，插入 sku-spec 表里
        List<SkuSpec> skuSpecs = SkuSpec.convert(skuSaveDTO.getBelongSpecs(),id,skuSaveDTO.getSpuId());
        try {
            skuSpecMapper.addSkuSpecs(skuSpecs);
            log.info("成功添加 sku 规格到 sku-spec 表，skuId=[{}]，spuId=[{}]",id,skuSaveDTO.getSpuId());
        }catch (Exception e) {
            log.error("添加 sku 规格到 sku-spec 表失败，skuId=[{}]，spuId=[{}]",id,skuSaveDTO.getSpuId());
            throw new SaveException(25005);
        }
        log.info("创建 SKU 成功，skuId=[{}]",id);
    }

    /**
     * 构建 sku 编码
     * @param spuId
     * @param belongSpecs
     * @return
     */
    private String buildCode(Long spuId, List<BelongSpec> belongSpecs) {
        StringBuffer code = new StringBuffer("");
        if(spuId == null || belongSpecs == null || belongSpecs.size() < 1) return code.toString();
        code.append(spuId).append("$");
        belongSpecs.forEach(belongSpec -> {
            code.append(belongSpec.getKeyId()).append("-");
            code.append(belongSpec.getValueId()).append("#");
        });
        return code.substring(0,code.length() - 1);
    }
}
