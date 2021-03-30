package io.github.talelin.latticy.mapper.my;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.my.SpuDetailImg;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Guiquan Chen
 * @Date 2021/3/23 17:26
 * @Version 1.0
 */
@Repository
public interface SpuDetailImgMapper extends BaseMapper<SpuDetailImg> {

    /**
     * 将指定spu的详情图数据，循环插入到数据表中
     * @param detailImgs
     */
    void addDetailImgs(@Param("detailImgs") List<SpuDetailImg> detailImgs);

    /**
     * 删除指定spu下的详情图片
     * @param spuId
     */
    void removeDetailImgsBySpuId(@Param("spuId") Long spuId);

}
