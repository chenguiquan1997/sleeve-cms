package io.github.talelin.latticy.mapper.my;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import io.github.talelin.latticy.model.my.Sku;

import java.util.List;
import java.util.Map;

@Repository
public interface SkuMapper {
    /**
     * 根据spuId 查询所属sku
     * @param spuId
     * @return List<Sku>
     */
    List<Sku> searchSkuListBySpuId(@Param("spuId") Long spuId);
}
