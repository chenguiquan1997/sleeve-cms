package io.github.talelin.latticy.vo.my;

import io.github.talelin.latticy.bo.my.CategoryBO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class CategoryDetailVO {

    private Long id;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 分类描述
     */
    private String description;
    /**
     * 是否上线/是否显示
     */
    private Boolean online;
    /**
     * 父级分类id
     */
    private Long parentId;
    /**
     * 是否为一级分类
     */
    private Integer isRoot;
    /**
     * 图片
     */
    private String img;
    /**
     * 当前类别为第几级分类
     */
    private Integer level;
    /**
     * 分类等级
     */
    private String levelName;
    /**
     * 父类名称
     */
    private String parentName;

    /**
     * @Description: 为当前分类添加LevelName信息
     * @param categoryBO
     * @Author: Guiquan Chen
     * @Date: 2021/2/21
     */
    public CategoryDetailVO(CategoryBO categoryBO) {
        BeanUtils.copyProperties(categoryBO,this);
        if(categoryBO.getLevel() == 1) {
            this.setLevelName("一级分类");
        } else if(categoryBO.getLevel() == 2) {
            this.setLevelName("二级分类");
        }
    }
}
