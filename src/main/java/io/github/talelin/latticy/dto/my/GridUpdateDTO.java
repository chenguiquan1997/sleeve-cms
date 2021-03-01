package io.github.talelin.latticy.dto.my;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * @Author Guiquan Chen
 * @Date 2021/2/28 19:18
 * @Version 1.0
 * 用于修改六宫格数据时，应用层接收数据
 */
@Data
public class GridUpdateDTO {
    /**
     * id
     */
    @NotNull
    @Positive
    private Long id;
    /**
     * 上下线
     */
    @NotNull
    private Boolean gridOnline;
    /**
     * 六宫格图片
     */
    @NotNull
    @NotEmpty
    private String gridImg;
}
