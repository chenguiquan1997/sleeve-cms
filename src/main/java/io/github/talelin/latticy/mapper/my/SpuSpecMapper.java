package io.github.talelin.latticy.mapper.my;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.my.SpuSpec;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Guiquan Chen
 * @Date 2021/4/21 15:08
 * @Version 1.0
 */
@Repository
public interface SpuSpecMapper extends BaseMapper<SpuSpec> {

    /**
     * 根据 spu id，查询所属 SPU
     * @param spuId
     * @return
     */
    List<SpuSpec> searchSpuSpecBySpuId(@Param("spuId") Long spuId);
}
