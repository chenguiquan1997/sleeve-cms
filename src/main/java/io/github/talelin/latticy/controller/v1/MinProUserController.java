package io.github.talelin.latticy.controller.v1;

import io.github.talelin.latticy.bo.my.MinUserBO;
import io.github.talelin.latticy.dto.my.MinUserDTO;
import io.github.talelin.latticy.service.imy.IMinUserService;
import io.github.talelin.latticy.vo.CreatedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.github.talelin.latticy.model.my.Page;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * @Author Guiquan Chen
 * @Date 2021/5/31 11:23
 * @Version 1.0
 * 小程序用户管理 api
 */

@RestController
@RequestMapping("/v1/min/user")
@Validated
public class MinProUserController {

    @Autowired
    private IMinUserService minUserService;

    @GetMapping("/all")
    public Page<MinUserBO> getMinUserAll(@RequestParam(name = "page",defaultValue = "1")
                              @Min(value = 1) Integer page,
                                         @RequestParam(name = "count", defaultValue = "10")
                              @Min(value = 3) @Max(value = 30) Integer count) {
        return null;
    }

    /**
     * @Description: 注册新用户
     * @param minUserDTO
     * @return io.github.talelin.latticy.vo.CreatedVO
     * @Author: Guiquan Chen
     * @Date: 2021/5/31
     */
    @PostMapping("/save")
    public CreatedVO save(@RequestBody @Validated MinUserDTO minUserDTO) {
        minUserService.save(minUserDTO);
        return new CreatedVO(1);
    }
}
