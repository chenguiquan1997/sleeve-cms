package io.github.talelin.latticy.mapper.my;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.my.SpuImg;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author Guiquan Chen
 * @Date 2021/3/23 16:40
 * @Version 1.0
 */
@Repository
public interface SpuImgMapper extends BaseMapper<SpuImg> {

    /**
     * 将指定spu的轮播图数据，循环插入到数据表中
     * @param rotationImgs
     */
    void addRotationImgs(@Param("rotationImgs") List<SpuImg> rotationImgs);

    /**
     * 删除指定spu下的轮播图片
     * @param spuId
     */
    void removeRotationImgsBySpuId(@Param("spuId") Long spuId);
}
