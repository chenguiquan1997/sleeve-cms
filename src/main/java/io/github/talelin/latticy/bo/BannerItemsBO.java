package io.github.talelin.latticy.bo;

import io.github.talelin.latticy.model.my.Banner;
import io.github.talelin.latticy.model.my.BannerItem;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Data
public class BannerItemsBO {

    private Long id;

    private String name;

    private String title;

    private String img;

    private String description;

    private List<BannerItem> bannerItems;

    public BannerItemsBO(Banner banner, List<BannerItem> bannerItems) {
        BeanUtils.copyProperties(banner,this);
        this.bannerItems = bannerItems;
    }
}
