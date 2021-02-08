package io.github.talelin.latticy.mapper.my;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.model.my.SpuDetail;
import io.github.talelin.latticy.model.my.SpuOutline;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SpuMapper {

    /**
     * 分页查询Spu概要信息
     */
    IPage<SpuOutline> searchSpuOutline(IPage<SpuOutline> page);

    /**
     * 根据spuId查询商品详情
     * @param spuId
     * @return
     */
    SpuDetail searchSpuDetailById(@Param("spuId") Long spuId);

    /**
     * 根据spuId 查询当前spu所拥有的商品规格
     * @param spuId
     * @return
     */
    List<Map<Object,Object>> searchSpecBySpuId(@Param("spuId") Long spuId);
}
