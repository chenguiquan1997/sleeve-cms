package io.github.talelin.latticy.service.impl.my;

import io.github.talelin.latticy.bo.my.SkuBO;
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
            log.error("当前SKU没有所属SPU，skuId=[{}]，spuId=[{}]",skuId,spuId);
            throw new NotFoundException(25002);
        }
        skuBO.setBelongSpu(spu.getTitle());
        // 获取SKU所拥有的规格
        List<SkuSpec> skuSpecs = skuSpecMapper.searchSkuSpecBySkuId(skuId);
        if(skuSpecs == null) {
            log.error("当前SKU无规格，skuId=[{}]",skuId);
            throw new NotFoundException(25002);
        }
        skuBO.setSkuSpecs(skuSpecs);
        return skuBO;
    }
}
