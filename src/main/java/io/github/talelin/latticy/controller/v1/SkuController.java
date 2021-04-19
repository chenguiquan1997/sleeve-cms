package io.github.talelin.latticy.controller.v1;

import io.github.talelin.latticy.bo.my.SkuBO;
import io.github.talelin.latticy.common.util.CommonUtils;
import io.github.talelin.latticy.model.my.Page;
import io.github.talelin.latticy.service.imy.ISkuService;
import io.github.talelin.latticy.vo.my.SkuDetailVO;
import io.github.talelin.latticy.vo.my.SkuOutlineVO;
import io.github.talelin.latticy.vo.my.SpuOwnSkusVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.github.talelin.latticy.model.my.Sku;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Map;

@RestController
@Validated
@RequestMapping("/v1/sku")
public class SkuController {

    @Autowired
    private ISkuService skuService;

    /**
     * @Description: 分页查询 sku 概要
     * @param page
     * @param count
     * @return io.github.talelin.latticy.model.my.Page
     * @Author: Guiquan Chen
     * @Date: 2021/4/12
     */
    @GetMapping("/summary")
    public Page getSkuSummary(@RequestParam(name = "page",defaultValue = "1")
                              @Min(value = 1) Integer page,
                              @RequestParam(name = "count", defaultValue = "10")
                              @Min(value = 3) @Max(value = 30) Integer count) {
        Map<String,Integer> pageMap = CommonUtils.convertPageParams(page,count);
        Page skuPage = skuService.searchSkuListByPage(pageMap,count);
        return skuPage;
    }

    /**
     * 通过spuid 查询所属的sku
     * @param id
     * @return
     */
    @GetMapping("/list/{id}")
    public List<SpuOwnSkusVO> searchSkusBySpuId(@PathVariable(name = "id") @Positive Long id ) {
        List<Sku> skuList = skuService.searchSkuListBySpuId(id);
        return SpuOwnSkusVO.convert(skuList);
    }

    /**
     * @Description: 获取指定sku详情
     * @param id sku id
     * @return io.github.talelin.latticy.vo.my.SkuDetailVO
     * @Author: Guiquan Chen
     * @Date: 2021/4/13
     */
    @GetMapping("/detail/{id}")
    public SkuDetailVO getSkuDetail(@PathVariable("id") @Positive Long id) {
        SkuBO skuBO = skuService.searchSkuDetailBySkuId(id);
        return SkuDetailVO.convert(skuBO);
    }
}
