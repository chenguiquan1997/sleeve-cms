package io.github.talelin.latticy.model.my;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * spu概要实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpuOutline extends Spu implements Serializable {

    private static final long serialVersionUID = -6220390572082701350L;
    /**
     * 当前商品所属分类名
     */
    private String categoryName;
}
