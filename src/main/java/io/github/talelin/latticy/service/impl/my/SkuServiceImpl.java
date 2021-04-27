package io.github.talelin.latticy.service.impl.my;

import com.alibaba.fastjson.JSON;
import io.github.talelin.latticy.bo.my.SkuBO;
import io.github.talelin.latticy.bo.my.SpecJsonBO;
import io.github.talelin.latticy.common.exception.UpdateException;
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
}
