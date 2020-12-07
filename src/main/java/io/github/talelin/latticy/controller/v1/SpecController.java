package io.github.talelin.latticy.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.common.util.CommonUtils;
import io.github.talelin.latticy.common.util.PageUtil;
import io.github.talelin.latticy.dto.SpecKeyDTO;
import io.github.talelin.latticy.dto.SpecValueDTO;
import io.github.talelin.latticy.model.my.Page;
import io.github.talelin.latticy.model.my.SpecKey;
import io.github.talelin.latticy.model.my.SpecValue;
import io.github.talelin.latticy.service.imy.ISpecKeyService;
import io.github.talelin.latticy.service.imy.ISpecValueService;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import net.sf.jsqlparser.statement.create.view.CreateView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Map;

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
        SpecKey specKey = new SpecKey();
        BeanUtils.copyProperties(specKeyDTO,specKey);
        specKeyService.save(specKey);
        return new CreatedVO(1);
    }

    /**
     * 新增规格值
     * @param specValueDTO
     * @return 创建成功VO
     */
    @PostMapping("/value/save")
    public CreatedVO saveSpecValue(@RequestBody SpecValueDTO specValueDTO) {
        SpecValue specValue = new SpecValue();
        BeanUtils.copyProperties(specValueDTO,specValue);
        specValueService.save(specValue);
        return new CreatedVO(1);
    }

}
