package io.github.talelin.latticy.mapper.my;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.model.my.SpuDetail;
import io.github.talelin.latticy.model.my.SpuOutline;
import org.apache.ibatis.annotations.Param;
import io.github.talelin.latticy.model.my.Spu;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SpuMapper extends BaseMapper<Spu> {

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
     * 查询当前SPU所属分类,从根分类，一直到直属分类
     * @param categoryId
     * @return
     */
    Map<String,String> searchCurrSpuBelongCategory(@Param("categoryId") Long categoryId);

    /**
     * 根据spuId 查询当前spu所拥有的商品规格
     * @param spuId
     * @return
     */
    List<Map<Object,Object>> searchSpecBySpuId(@Param("spuId") Long spuId);

    /**
     * 创建 SPU，返回自增主键 id
     * @param spu
     */
    void insertSpu(@Param("spu") Spu spu);

    /**
     * 逻辑删除 spu
     * @param id
     */
    void removeSpuById(@Param("id") Long id);
}
