package io.github.talelin.latticy.service.imy;

import io.github.talelin.latticy.dto.my.BannerItemDTO;
import io.github.talelin.latticy.model.my.BannerItem;

public interface IBannerItemService {

    /**
     * 根据 id 更新 bannerItem
     * @param id
     * @param bannerItemDTO
     * @return
     */
    boolean updateById(Long id, BannerItemDTO bannerItemDTO);

    /**
     * 添加一个bannerItem
     * @param bannerItemDTO
     * @return
     */
    boolean save(BannerItemDTO bannerItemDTO);

    /**
     * 根据 id 删除一个 bannerItem
     * @param id
     */
    void remove(Long id);

    /**
     * 根据 id 查询banner-item
     * @param id
     * @return
     */
    BannerItem searchOneById(Long id);

}
