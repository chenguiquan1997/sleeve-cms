package io.github.talelin.latticy.bo.my;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Guiquan Chen
 * @Date 2021/3/15 10:44
 * @Version 1.0
 * 获取分类以及所属子分类用到的实体类
 */
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CategoryNameBO implements Serializable {

    private static final long serialVersionUID = -5389754190369738163L;
    /**
     * 对应前端级联选择器的value
     */
    private Long value;
    /**
     * 对应前端级联选择器的label
     */
    private String label;
    /**
     * 所属的子分类
     */
    private List<CategoryNameBO> children;


}
