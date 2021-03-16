package io.github.talelin.latticy.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.common.util.PageUtil;
import io.github.talelin.latticy.dto.my.SpecKeyDTO;
import io.github.talelin.latticy.dto.my.SpecKeyUpdateDTO;
import io.github.talelin.latticy.dto.my.SpecValueDTO;
import io.github.talelin.latticy.dto.my.SpecValueUpdateDTO;
import io.github.talelin.latticy.model.my.SpecKey;
import io.github.talelin.latticy.model.my.SpecValue;
import io.github.talelin.latticy.service.imy.ISpecKeyService;
import io.github.talelin.latticy.service.imy.ISpecValueService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import io.github.talelin.latticy.vo.my.SpecKeyVO;
import io.github.talelin.latticy.vo.my.SpecSketchVO;
import io.github.talelin.latticy.vo.my.SpecSummaryVO;
import io.github.talelin.latticy.vo.my.SpecValueVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.*;
import java.util.List;

@RequestMapping("/v1/spec")
@RestController
@Validated
public class SpecController {

    @Autowired
    private ISpecKeyService specKeyService;

    @Autowired
    private ISpecValueService specValueService;

    /**
     * 分页查询规格名
     * @param page 当前页码
     * @param size 需要查询记录数量
     * @return 分页对象VO
     */
    @GetMapping("/key/all")
    public PageResponseVO<SpecKey> searchSpecKey(@RequestParam(name = "page",defaultValue = "1")
                                                 @Min(value = 1) Integer page,
                                                 @RequestParam(name = "size", defaultValue = "20")
                                                 @Min(value = 1) @Max(value = 30) Integer size) {
       //mybatisPlus分页插件会自行对page页码进行-1操作，来拟合sql语句中的limit
       IPage<SpecKey> specKeyPage = specKeyService.searchAllSpecKey(page,size);
       PageResponseVO<SpecKey> specKeyPageResponseVO = PageUtil.build(specKeyPage);
       return specKeyPageResponseVO;
    }

    /**
     * 根据规格名id，分页查询对应的规格值
     * @param page 当前页码
     * @param size 需要查询记录数量
     * @param keyId 规格名id
     * @return 分页VO
     */
    @GetMapping("/value/all/{id}")
    public PageResponseVO<SpecValue> searchSpecValue(@RequestParam(name = "page",defaultValue = "1")
                                                     @Min(value = 1) Integer page,
                                                     @RequestParam(name = "size", defaultValue = "20")
                                                     @Min(value = 1) @Max(value = 30) Integer size,
                                                     @PathVariable(name = "id") @Positive @NotNull Long keyId) {
        IPage<SpecValue> specValuePage = specValueService.searchAllSpecValueByKey(page,size,keyId);
        return PageUtil.build(specValuePage);
    }

    /**
     * 新增规格名
     * @param specKeyDTO
     * @return 创建成功VO
     */
    @PostMapping("/key/save")
    public CreatedVO saveSpecKey(@RequestBody @Validated SpecKeyDTO specKeyDTO) {
        specKeyService.save(specKeyDTO);
        return new CreatedVO(1);
    }

    /**
     * 新增规格值
     * @param specValueDTO
     * @return 创建成功VO
     */
    @PostMapping("/value/save")
    public CreatedVO saveSpecValue(@RequestBody SpecValueDTO specValueDTO) {
        specValueService.save(specValueDTO);
        return new CreatedVO(1);
    }

    /**
     * @Description: 根据规格id,查询指定规格
     * @param id 规格id
     * @return io.github.talelin.latticy.vo.my.SpecKeyVO
     * @Author: Guiquan Chen
     * @Date: 2021/3/3
     */
    @GetMapping("/key/{id}")
    public SpecKeyVO getSpecById(@PathVariable("id") @NotNull @Positive Long id) {
        SpecKey specKey = specKeyService.searchOneById(id);
        return new SpecKeyVO(specKey);
    }

    /**
     * @Description: 根据id,查询指定规格值
     * @param id 规格值id
     * @return io.github.talelin.latticy.vo.my.SpecValueVO
     * @Author: Guiquan Chen
     * @Date: 2021/3/8
     */
    @GetMapping("/value/{id}")
    public SpecValueVO getValueById(@PathVariable("id") @NotNull @Positive Long id) {
        SpecValue specValue = specValueService.getValueById(id);
        return new SpecValueVO(specValue);
    }

    /**
     * @Description: 更新规格名
     * @param specKeyUpdateDTO
     * @return io.github.talelin.latticy.vo.UpdatedVO
     * @Author: Guiquan Chen
     * @Date: 2021/3/7
     */
    @PutMapping("/key/update")
    public UpdatedVO updateSpecKey(@RequestBody @Validated SpecKeyUpdateDTO specKeyUpdateDTO) {
      specKeyService.update(specKeyUpdateDTO);
      return new UpdatedVO(2);
    }

    /**
     * @Description: 更新规格值
     * @param specValueUpdateDTO
     * @return io.github.talelin.latticy.vo.UpdatedVO
     * @Author: Guiquan Chen
     * @Date: 2021/3/7
     */
    @PutMapping("/value/update")
    public UpdatedVO updateSpecValue(@RequestBody @Validated SpecValueUpdateDTO specValueUpdateDTO) {
        specValueService.update(specValueUpdateDTO);
        return new UpdatedVO(2);
    }

    /**
     * @Description: 根据id, 删除指定规格
     * @param id 规格id
     * @return io.github.talelin.latticy.vo.DeletedVO
     * @Author: Guiquan Chen
     * @Date: 2021/3/8
     */
    @DeleteMapping("/key/delete/{id}")
    public DeletedVO deleteSpecKey(@PathVariable("id") @NotNull @Positive Long id) {
        specKeyService.delete(id);
        return new DeletedVO(3);
    }
    /**
     * @Description: 删除指定规格值
     * @param id 规格值id
     * @Author: Guiquan Chen
     * @Date: 2021/3/9
     */
    @DeleteMapping("/value/delete/{id}")
    public DeletedVO deleteSpecValue(@PathVariable("id") @NotNull @Positive Long id) {
        specValueService.delete(id);
        return new DeletedVO(3);
    }

    /**
     * @Description: 获取规格概要数据
     * @return java.util.List<io.github.talelin.latticy.vo.my.SpecSummaryVO>
     * @Author: Guiquan Chen
     * @Date: 2021/3/16
     */
    @GetMapping("/key/summary")
    public List<SpecSummaryVO> getSpecsSummary() {
        List<SpecKey> specKeys = specKeyService.getSpecSummary();
        return SpecSummaryVO.convert(specKeys);
    }

    /**
     * @Description: 根据规格id列表，获取相应的规格
     * @param ids 规格id的拼接字符串
     * @return java.util.List<io.github.talelin.latticy.vo.my.SpecSummaryVO>
     * @Author: Guiquan Chen
     * @Date: 2021/3/16
     */
    @GetMapping("/key/sketch/ids")
    public List<SpecSketchVO> geteSpecsSummaryByIds(@RequestParam(name = "ids") @NotEmpty @NotNull String ids) {
        List<SpecKey> specKeys = specKeyService.getSpecSummaryByIds(ids);
        return SpecSketchVO.convert(specKeys);
    }

}
