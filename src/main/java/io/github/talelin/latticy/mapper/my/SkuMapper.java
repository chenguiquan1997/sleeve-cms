package io.github.talelin.latticy.mapper.my;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.my.SkuSummary;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import io.github.talelin.latticy.model.my.Sku;
import io.github.talelin.latticy.model.my.Page;

import java.util.List;
import java.util.Map;

@Repository
public interface SkuMapper extends BaseMapper<Sku> {
    /**
     * 根据spuId 查询所属sku
     * @param spuId
     * @return List<Sku>
     */
    List<Sku> searchSkuListBySpuId(@Param("spuId") Long spuId);

    /**
     * 分页查询sku
     * @param start 从当前位置开始查询
     * @param count 当前页数据量
     * @return Page<SkuSummary>
     */
    List<SkuSummary> searchSkuListByPage(@Param("start") Integer start, @Param("count") Integer count);


    /**
     * 获取sku总数量
     * @return
     */
    Integer searchAllSkuCount();
}
