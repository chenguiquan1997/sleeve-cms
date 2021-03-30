package io.github.talelin.latticy.mapper.my;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.my.SpuKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Guiquan Chen
 * @Date 2021/3/24 7:56
 * @Version 1.0
 */
@Repository
public interface SpuKeyMapper extends BaseMapper<SpuKey> {

    /**
     * 循环插入spu-规格的关联关系
     * @param spuKeys spu-规格的关联关系集合
     */
    void addSpuKey(@Param("spuKeys") List<SpuKey> spuKeys);

    /**
     * 删除指定spu-规格的关联关系
     * @param spuId
     */
    void removeSpuKeyBySpuId(@Param("spuId") Long spuId);

}
