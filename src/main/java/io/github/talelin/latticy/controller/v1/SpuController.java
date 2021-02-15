package io.github.talelin.latticy.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.bo.my.SpuDetailBO;
import io.github.talelin.latticy.common.util.CommonUtils;
import io.github.talelin.latticy.common.util.PageUtil;
import io.github.talelin.latticy.model.my.SpuOutline;
import io.github.talelin.latticy.service.imy.ISpuService;
import io.github.talelin.latticy.vo.PageResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@RestController
@Validated
@RequestMapping("/v1/spu")
public class SpuController {

    @Autowired
    private ISpuService spuService;

    /**
     * 分页查询Spu概要信息
     * @param page 页码
     * @param count 当前页记录数量
     * @return
     */
    @GetMapping("/outline/all")
    public PageResponseVO<SpuOutline> searchSpuOutline(@RequestParam(name = "page",defaultValue = "1")
                                                       @Min(1) Integer page,
                                                       @RequestParam(name = "count",defaultValue = "20")
                                                       @Min(3) @Max(30) Integer count) {
         IPage<SpuOutline> spuOutlinePage = spuService.searchSpuOutline(page,count);
         PageResponseVO vo = PageUtil.build(spuOutlinePage);
         vo.setItems(CommonUtils.convertToSpuOutlineVO(vo.getItems()));
         return vo;
    }

    /**
     * 根据spuId查询商品详情
     * @param id
     */
    @GetMapping("/detail/{id}")
    public SpuDetailBO searchSpuDetail(@PathVariable(name = "id") @Positive Long id) {
        SpuDetailBO spuDetailBO = spuService.searchSpuDetailById(id);
        return spuDetailBO;
    }
}
