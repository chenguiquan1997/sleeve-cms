package io.github.talelin.latticy.controller.v1;

import io.github.talelin.latticy.dto.my.BannerItemDTO;
import io.github.talelin.latticy.model.my.BannerItem;
import io.github.talelin.latticy.service.imy.IBannerItemService;
import io.github.talelin.latticy.service.imy.IBannerItemTypeService;
import io.github.talelin.latticy.vo.UpdatedVO;
import io.github.talelin.latticy.vo.my.BannerItemTypeVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/banner/item")
@Validated
public class BannerItemController {

    @Autowired
    private IBannerItemService bannerItemService;

    @Autowired
    private IBannerItemTypeService bannerItemTypeService;

    /**
     * 修改banner-item
     * @param bannerItemDTO
     * @return
     */
    @PutMapping("/update")
    public UpdatedVO updateItem(@RequestBody @Validated BannerItemDTO bannerItemDTO) {
        Long id = bannerItemDTO.getId();
        BannerItem item = new BannerItem();
        BeanUtils.copyProperties(bannerItemDTO,item);
        Integer type = item.getTypeByTypeName(item.getTypeName());
        item.setType(type);
        bannerItemService.updateById(id,item);
        return new UpdatedVO(2);
    }

    @RequestMapping("/search/types")
    public List<Map<String,String>> searchItemTypes() {
       List<Map<String,String>> typeList = bannerItemTypeService.searchAll();
        System.out.println(typeList);
       return typeList;
    }

}
