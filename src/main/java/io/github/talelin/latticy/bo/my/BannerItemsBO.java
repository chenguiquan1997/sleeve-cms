package io.github.talelin.latticy.bo.my;

import io.github.talelin.latticy.common.enumeration.my.BannerItemTypeEnum;
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
//        bannerItems.forEach(bannerItem -> {
//            Integer typeCode = Integer.valueOf(bannerItem.getType());
//            BannerItemTypeEnum typeEnum = BannerItemTypeEnum.getType(typeCode);
//            if(typeEnum != null) {
//                bannerItem.setTypeName(typeEnum.getValue());
//            }
//        });
        this.bannerItems = bannerItems;
    }
}
