package io.github.talelin.latticy.service.impl.my;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.talelin.latticy.bo.my.SpuDetailBO;
import io.github.talelin.latticy.common.exception.DeleteException;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.dto.my.SpuSaveDTO;
import io.github.talelin.latticy.dto.my.SpuUpdateDTO;
import io.github.talelin.latticy.mapper.my.*;
import io.github.talelin.latticy.model.my.*;
import io.github.talelin.latticy.service.imy.ISpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class SpuServiceImpl implements ISpuService {

    @Autowired
    private SpuMapper spuMapper;

    @Autowired
    private SpecKeyMapper specKeyMapper;

    @Autowired
    private SpuImgMapper spuImgMapper;

    @Autowired
    private SpuDetailImgMapper spuDetailImgMapper;

    @Autowired
    private SpuKeyMapper spuKeyMapper;

    /**
     * 分页查询Spu概要信息
     * @param page 页码
     * @param count 当前页记录数量
     * @return
     */
    @Override
    public IPage<SpuOutline> searchSpuOutline(Integer page, Integer count) {
        IPage<SpuOutline> pager = new Page<>(page,count);
        return spuMapper.searchSpuOutline(pager);
    }

    /**
     * 根据spuId查询商品详情
     * @param spuId
     * @return
     */
    @Override
    public SpuDetailBO searchSpuDetailById(Long spuId) {
        // 可以查询出SPU的基本信息和轮播图信息
        SpuDetail spuDetail = spuMapper.searchSpuDetailById(spuId);
        // 需要查询当前SPU所属分类信息,从根分类一直到直属分类
        StringBuffer buffer = this.mergeSpuCategorys(spuDetail.getCategoryId().longValue());
        spuDetail.setCategoryName(buffer.toString());
        // 拆分tag标签
        List<String> tagList = this.splitTags(spuDetail.getTags());
        // 获取当前SPU所拥有的规格
        List<Map<Object,Object>> specList = spuMapper.searchSpecBySpuId(spuId);
        // 获取可视化规格
        String sketchSpec = this.getSketchSpec(spuDetail.getSketchSpecId());
        SpuDetailBO spuDetailBO = new SpuDetailBO();
        spuDetailBO.convert(spuDetail,specList,tagList,sketchSpec);
        return spuDetailBO;
    }

    /**
     * @Description: 查询当前SPU所属分类,从根分类，一直到直属分类
     * @param categoryId 分类id
     * @return java.lang.StringBuffer
     * @Author: Guiquan Chen
     * @Date: 2021/3/14
     */
    private StringBuffer mergeSpuCategorys(Long categoryId) {
        StringBuffer buffer = new StringBuffer("");
        if(categoryId == null || categoryId < 1) return buffer;
        Map<String,String> map = spuMapper.searchCurrSpuBelongCategory(categoryId);
        buffer.append(map.get("root_category"));
        buffer.append(" > ");
        buffer.append(map.get("directly_category"));
        return buffer;
    }

    /**
     * @Description: 拆分SPU的标签
     * @param tags 标签字符串
     * @return java.util.List<java.lang.String>
     * @Author: Guiquan Chen
     * @Date: 2021/3/10
     */
    private List<String> splitTags(String tags) {
        // todo 需要判断空
       List<String> tagList = new ArrayList<>();
       if(tags == null) return tagList;
       String[] tagArr = tags.split("\\$");
       return Arrays.asList(tagArr);
    }

    /**
     * @Description: 获取可视化规格名称
     * @param specId 规格id
     * @return java.lang.String
     * @Author: Guiquan Chen
     * @Date: 2021/3/22
     */
    private String getSketchSpec(Long specId) {
        if(specId == null || specId < 1) return null;
        SpecKey specKey = specKeyMapper.selectById(specId);
        if(specKey == null) return null;
        return specKey.getName();
    }

    @Override
    public List<Map<Object, Object>> searchSpecBySpuId(Long spuId) {
        return null;
    }

    /**
     * @Description: 更新 SPU
     * @param spuUpdateDTO
     * @Author: Guiquan Chen
     * @Date: 2021/3/23
     */
    @Override
    @Transactional // 需要同时操作多张数据表，需要添加事务注解
    public void update(SpuUpdateDTO spuUpdateDTO) {
        // spu
        Spu spu = Spu.convert(spuUpdateDTO);
        spuMapper.updateById(spu);
        // 轮播图,先删除掉，然后在插入
        Long spuId = spuUpdateDTO.getId();
        spuImgMapper.removeRotationImgsBySpuId(spuId);
        List<String> rotationImgs = spuUpdateDTO.getRotationImgData();
        List<SpuImg> spuImgs = SpuImg.construct(rotationImgs,spuId);
        spuImgMapper.addRotationImgs(spuImgs);
        // 详情图,先删除掉，然后在插入
        spuDetailImgMapper.removeDetailImgsBySpuId(spuId);
        List<String> detailImgs = spuUpdateDTO.getDetailImgData();
        List<SpuDetailImg> spuDetailImgs = SpuDetailImg.contruct(detailImgs,spuId);
        spuDetailImgMapper.addDetailImgs(spuDetailImgs);
        // 更新spu-规格 关联表
        List<Long> specs = spuUpdateDTO.getSpuSpecs();
        List<SpuKey> spuKeys = SpuKey.construct(specs,spuId);
        spuKeyMapper.removeSpuKeyBySpuId(spuId);
        spuKeyMapper.addSpuKey(spuKeys);
    }

    /**
     * @Description: 创建 SPU
     * @param spuSaveDTO
     * @Author: Guiquan Chen
     * @Date: 2021/3/29
     */
    @Override
    @Transactional
    public void save(SpuSaveDTO spuSaveDTO) {
        // 先向spu表添加数据
        Spu spu = Spu.convert(spuSaveDTO);
        spuMapper.insertSpu(spu);
        Long spuId = spu.getId();
        //添加轮播图
        List<String> rotationImgs = spuSaveDTO.getRotationImgData();
        List<SpuImg> spuImgs = SpuImg.construct(rotationImgs,spuId);
        spuImgMapper.addRotationImgs(spuImgs);
        //添加详情图
        List<String> detailImgs = spuSaveDTO.getDetailImgData();
        List<SpuDetailImg> spuDetailImgs = SpuDetailImg.contruct(detailImgs,spuId);
        spuDetailImgMapper.addDetailImgs(spuDetailImgs);
        //添加spu-规格 关联表
        List<Long> specs = spuSaveDTO.getSpuSpecs();
        List<SpuKey> spuKeys = SpuKey.construct(specs,spuId);
        spuKeyMapper.addSpuKey(spuKeys);
    }

    /**
     * @Description: 逻辑删除 spu
     * @param id spu id
     * @Author: Guiquan Chen
     * @Date: 2021/3/29
     */
    @Override
    public void removeSpuById(Long id) {
        Spu spu = spuMapper.selectById(id);
        if(spu == null) {
            throw new NotFoundException(24001);
        }
        try {
            spuMapper.removeSpuById(id);
        }catch (Exception e) {
            throw new DeleteException(21002);
        }
    }


}
