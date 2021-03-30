package io.github.talelin.latticy.controller.v1;

import io.github.talelin.latticy.common.util.CommonUtils;
import io.github.talelin.latticy.service.imy.ISkuService;
import io.github.talelin.latticy.vo.my.SkuOutlineVO;
import io.github.talelin.latticy.vo.my.SpuOwnSkusVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.github.talelin.latticy.model.my.Sku;

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
     * 通过spuid 查询所属的sku
     * @param id
     * @return
     */
    @GetMapping("/list/{id}")
    public List<SpuOwnSkusVO> searchSkusBySpuId(@PathVariable(name = "id") @Positive Long id ) {
        List<Sku> skuList = skuService.searchSkuListBySpuId(id);
        return SpuOwnSkusVO.convert(skuList);
    }
}
