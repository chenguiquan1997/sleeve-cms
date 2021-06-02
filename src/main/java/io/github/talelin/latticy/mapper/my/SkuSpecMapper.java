package io.github.talelin.latticy.mapper.my;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.bo.my.SpecJsonBO;
import io.github.talelin.latticy.model.my.SkuSpec;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Guiquan Chen
 * @Date 2021/4/13 11:02
 * @Version 1.0
 */
@Repository
public interface SkuSpecMapper extends BaseMapper<SkuSpec> {

    /**
     * 获取指定SKU所拥有的规格
     * @param skuId
     * @return
     */
    List<SkuSpec> searchSkuSpecBySkuId(@Param("skuId") Long skuId);

    /**
     * 删除指定sku所拥有的规格
     * @param skuId
     */
    void removeSpecBySkuId(@Param("skuId") Long skuId);

    /**
     * 添加指定sku所拥有的规格
     * @param skuSpecs
     */
    void addSkuSpecs(@Param("specs") List<SkuSpec> skuSpecs);
}
