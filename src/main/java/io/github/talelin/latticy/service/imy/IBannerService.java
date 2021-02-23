package io.github.talelin.latticy.service.imy;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.bo.my.BannerItemsBO;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.my.BannerDTO;
import io.github.talelin.latticy.model.my.Banner;

public interface IBannerService {

    IPage<Banner> searchAllBanner(Page page);

    Integer updateBannerById(Long id, BannerDTO bannerDTO);

    void removeBannerById(Long id);

    BannerItemsBO searchBannerItems(Long bannerId);

    /**
     * 保存 banner 数据
     * @param banner
     */
    void saveBanner(Banner banner);

}
