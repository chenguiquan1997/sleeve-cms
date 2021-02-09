package io.github.talelin.latticy.mapper.my;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.my.BannerItem;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerItemMapper extends BaseMapper<BannerItem> {

    /**
     * 根据id 逻辑删除 banner-item
     * @param id
     */
    void removeItemById(@Param("id") Long id);

}
