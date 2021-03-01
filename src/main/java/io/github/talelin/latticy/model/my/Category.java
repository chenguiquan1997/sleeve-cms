package io.github.talelin.latticy.model.my;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 商品分类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 6898278172178595160L;
    /**
     * id,注解数据库自动生成
     */
    @TableId(value = "id", type = IdType.AUTO)
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
     * 当前分类是否为根节点（一级分类）
     */
    private Integer isRoot;
    /**
     * 是否上线/是否显示
     */
    private Boolean online;
    /**
     * 父级分类id
     */
    private Long parentId;
    /**
     * 图片
     */
    private String img;
    /**
     * 当前类别为第几级分类
     */
    private Integer level;
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
    /**
     * 当前六宫格是否上线的标记
     */
    private Boolean gridOnline;
}
