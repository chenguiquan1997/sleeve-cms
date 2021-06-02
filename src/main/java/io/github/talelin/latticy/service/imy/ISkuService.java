package io.github.talelin.latticy.service.imy;

import io.github.talelin.latticy.bo.my.SkuBO;
import io.github.talelin.latticy.dto.my.SkuSaveDTO;
import io.github.talelin.latticy.dto.my.SkuUpdateDTO;
import io.github.talelin.latticy.model.my.Page;
import io.github.talelin.latticy.model.my.Sku;
import io.github.talelin.latticy.model.my.SkuSpec;
import io.github.talelin.latticy.model.my.SkuSummary;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ISkuService {

    /**
     * 根据spu id 查询所属Sku
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
     * 分页查询指定Spu下的sku列表
     * @param pageMap 分页参数
     * @param size 每页数据量
     * @param spuId spu id
     * @return
     */
     Page searchSkuListBySpuId(Map<String,Integer> pageMap, Integer size, Long spuId);

    /**
     * 根据 sku id , 获取 sku 详情
     * @param skuId
     * @return
     */
    SkuBO searchSkuDetailBySkuId(Long skuId);

    /**
     * 更新 sku
     * @param skuUpdateDTO
     */
    void update(SkuUpdateDTO skuUpdateDTO);

    /**
     * 创建 sku
     * @param skuSaveDTO
     */
    void save(SkuSaveDTO skuSaveDTO);

}
