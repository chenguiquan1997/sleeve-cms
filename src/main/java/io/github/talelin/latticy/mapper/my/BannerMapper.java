package io.github.talelin.latticy.mapper.my;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.my.Banner;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 在 mybatisPlus中，继承了BaseMapper后，就可以像jpa一样，使用一些基本的内置方法
 * 内部的泛型表示“将从数据库中查询出来的数据，映射到相应的实体类”
 */
@Repository
public interface BannerMapper extends BaseMapper<Banner> {
    /**
     * 获取所有Banner
     * @return
     */
    List<Banner> searchAllBanner();

    /**
     * 通过 id 逻辑删除当前 banner
     * @param id
     */
    void removeBannerById(@Param("id") Long id);


}
