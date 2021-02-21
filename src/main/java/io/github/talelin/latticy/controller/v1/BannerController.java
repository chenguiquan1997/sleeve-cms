package io.github.talelin.latticy.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.bo.my.BannerItemsBO;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.common.util.PageUtil;
import io.github.talelin.latticy.dto.my.BannerDTO;
import io.github.talelin.latticy.model.my.Banner;
import io.github.talelin.latticy.service.imy.IBannerService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;


@RestController
@RequestMapping("v1/banner")
//必须加当前注解，参数上的校验注解才可以生效,并且这个注解需要加到class上,它就如同一个校验的开关一样
@Validated
public class BannerController {

    @Autowired
    private IBannerService bannerService;

    /**
     * 获取所有banner数据
     * @param pageSize 页码
     * @param count 每页查询的记录数量
     * @return PageResponseVO<Banner>
     * all?page=1&count=10
     */
    @GetMapping("/all")
    public PageResponseVO<Banner> getAllBanner(@RequestParam(name = "page", required = false, defaultValue = "0")
                                     @Min(value = 1, message = "{paging.page.min}") Integer pageSize,
                                     @RequestParam(name = "count", required = false, defaultValue = "20")
                                     @Max(value = 50) @Min(value = 1) Integer count) {
        Page page = new Page(pageSize-1,count);
        IPage<Banner> bannerPage = bannerService.searchAllBanner(page);
        PageResponseVO<Banner> bannerPageResponseVO = PageUtil.build(bannerPage);
        return bannerPageResponseVO;
    }

    /**
     * 根据 id 修改 Banner 数据
     * @param id
     * @param bannerDTO
     */
    @PutMapping("/updateBannerBy/{id}")
    public UpdatedVO updateBannerById(@PathVariable(name = "id") @Positive Long id,
                                 @RequestBody @Validated BannerDTO bannerDTO) {
        Integer res = bannerService.updateBannerById(id,bannerDTO);
        if(res == 1) {
            return new UpdatedVO(2);
        }
        return new UpdatedVO(21000);
    }

    /**
     * 根据id 删除Banner
     * @param id
     * @return
     */
    @DeleteMapping("/remove/{id}")
    public DeletedVO removeBannerById(@PathVariable(name = "id") @Positive Long id) {
        bannerService.removeBannerById(id);
        return new DeletedVO(3);
    }

    /**
     * 获取banner，以及与Banner相关联的items
     * @param id
     * @return
     */
    @GetMapping("/searchBannerAndItems/{id}")
    public BannerItemsBO getBannerAndItems(@PathVariable(name = "id") @Positive Long id) {
        return bannerService.searchBannerItems(id);
    }

    /**
     * 新增Banner
     * @param bannerDTO
     * @return
     */
    @PostMapping("/save")
    public CreatedVO saveBanner(@RequestBody @Validated BannerDTO bannerDTO) {
        Banner banner = new Banner();
        BeanUtils.copyProperties(bannerDTO,banner);
        bannerService.saveBanner(banner);
        return new CreatedVO(1);
    }
}
