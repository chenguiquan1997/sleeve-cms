package io.github.talelin.latticy.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.bo.my.SpuDetailBO;
import io.github.talelin.latticy.common.util.CommonUtils;
import io.github.talelin.latticy.common.util.PageUtil;
import io.github.talelin.latticy.dto.my.SpuSaveDTO;
import io.github.talelin.latticy.dto.my.SpuUpdateDTO;
import io.github.talelin.latticy.model.my.SpuOutline;
import io.github.talelin.latticy.service.imy.ISpuService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import io.github.talelin.latticy.vo.my.SpuOwnSkusVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@Validated
@RequestMapping("/v1/spu")
public class SpuController {

    @Autowired
    private ISpuService spuService;

    /**
     * 分页查询Spu概要信息
     * @param page 页码
     * @param count 当前页数据量
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

    /**
     * @Description: 获取当前 spu 所拥有的 sku 列表
     * @param id spu id
     * @return java.util.List<io.github.talelin.latticy.vo.my.SpuOwnSkusVO>
     * @Author: Guiquan Chen
     * @Date: 2021/3/16
     */
    @GetMapping("/own/sku/{id}")
    public List<SpuOwnSkusVO> searchSkuBySpuId(@PathVariable("id") @NotNull @Positive Long id) {
      return null;
    }

    /**
     * @Description: 更新 SPU
     * @param spuUpdateDTO 接收SPU传参
     * @return io.github.talelin.latticy.vo.UpdatedVO
     * @Author: Guiquan Chen
     * @Date: 2021/3/23
     */
    @PutMapping("/update")
    public UpdatedVO updateSpu(@RequestBody @Validated SpuUpdateDTO spuUpdateDTO) {
        spuService.update(spuUpdateDTO);
        return new UpdatedVO(2);
    }

    /**
     * @Description: 创建 SPU
     * @param spuSaveDTO
     * @return io.github.talelin.latticy.vo.CreatedVO
     * @Author: Guiquan Chen
     * @Date: 2021/3/29
     */
    @PostMapping("/save")
    public CreatedVO saveSpu(@RequestBody @Validated SpuSaveDTO spuSaveDTO) {
        spuService.save(spuSaveDTO);
        return new CreatedVO(1);
    }

    /**
     * @Description: 根据id, 逻辑删除指定SPU
     * @param id spu id
     * @return io.github.talelin.latticy.vo.DeletedVO
     * @Author: Guiquan Chen
     * @Date: 2021/3/29
     */
    @DeleteMapping("/remove/{id}")
    public DeletedVO removeSpu(@PathVariable("id") @Positive Long id) {
        spuService.removeSpuById(id);
        return new DeletedVO(3);
    }
}
