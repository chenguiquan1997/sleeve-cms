package io.github.talelin.latticy.service.imy;

import io.github.talelin.latticy.bo.my.SkuBO;
import io.github.talelin.latticy.model.my.Page;
import io.github.talelin.latticy.model.my.Sku;
import io.github.talelin.latticy.model.my.SkuSpec;
import io.github.talelin.latticy.model.my.SkuSummary;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ISkuService {

    /**
     * 根据spuid 查询所属Sku
     * @param spuId
     * @return
     */
    List<Sku> searchSkuListBySpuId(Long spuId);

    /**
     * 分页查询sku
     * @param pageMap 分页参数
     * @param size 每页数据量
     */
    Page searchSkuListByPage(Map<String,Integer> pageMap, Integer size);

    /**
     *
     * @param skuId
     * @return
     */
    SkuBO searchSkuDetailBySkuId(Long skuId);


}
