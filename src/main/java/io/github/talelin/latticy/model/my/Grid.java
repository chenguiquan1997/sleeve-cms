package io.github.talelin.latticy.model.my;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author Guiquan Chen
 * @Date 2021/2/24 16:34
 * @Version 1.0
 * 六宫格实体类
 */
@Data
public class Grid implements Serializable {

    private static final long serialVersionUID = 6981054705622816978L;
    /**
     * id
     */
    private Long id;
    /**
     * 分类名称
     */
    private String name;
    /**
     * 当前六宫格是否上线/是否显示
     */
    private Boolean gridOnline;
    /**
     * 一级分类索引
     */
    private Integer idx;
    /**
     * 分类顶级图片
     */
    private String gridImg;
    /**
     * 是否属于六宫格中的分类
     */
    private Boolean isGrid;
}
