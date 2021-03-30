package io.github.talelin.latticy.controller.v1;

import io.github.talelin.latticy.dto.my.BannerItemDTO;
import io.github.talelin.latticy.model.my.BannerItem;
import io.github.talelin.latticy.service.imy.IBannerItemService;
import io.github.talelin.latticy.service.imy.IBannerItemTypeService;

import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import io.github.talelin.latticy.vo.my.BannerItemTypeVO;
import io.github.talelin.latticy.vo.my.BannerItemVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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
    @PutMapping("/update/{id}")
    public UpdatedVO updateItem(@RequestBody @Validated BannerItemDTO bannerItemDTO,
                                @PathVariable("id") @NotNull(message = "{id.notNull}")
                                        Long id) {
        bannerItemService.updateById(id,bannerItemDTO);
        return new UpdatedVO(2);
    }

    /**
     * 获取banner-item所有类型列表
     * @return
     */
    @GetMapping("/search/types")
    public List<Map<String,String>> searchItemTypes() {
       List<Map<String,String>> typeList = bannerItemTypeService.searchAll();
       return typeList;
    }

    /**
     * 根据id查找banner-item
     * @param id
     * @return
     */
    @GetMapping("/search/{id}")
    public BannerItemVO searchItemById(@PathVariable(name = "id") @Positive @NotNull Long id) {
        BannerItem bannerItem = bannerItemService.searchOneById(id);
        return new BannerItemVO(bannerItem);
    }

    /**
     * 添加Banner-item
     * @param bannerItemDTO
     */
    @PostMapping("/add")
    public CreatedVO addItem(@Validated @RequestBody BannerItemDTO bannerItemDTO) {
        Boolean flag = bannerItemService.save(bannerItemDTO);
        if(flag) {
            return new CreatedVO(21004);
        }
        return new CreatedVO(21003);
    }

    /**
     * @Description: 根据 id 逻辑删除指定banner-item
     * @param id
     * @return: DeletedVO
     * @Author: Guiquan Chen
     * @Date: 2021/2/23
     */
    @DeleteMapping("/remove/{id}")
    public DeletedVO removeItemById(@PathVariable("id") @NotNull @Positive Long id) {
        bannerItemService.remove(id);
        return new DeletedVO(3);
    }
}
