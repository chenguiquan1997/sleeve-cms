package io.github.talelin.latticy.model.my;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * spu概要实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpuOutline extends Spu{
    /**
     * 当前商品所属分类名
     */
    private String categoryName;
}
