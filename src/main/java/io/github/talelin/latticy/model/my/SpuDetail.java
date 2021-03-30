package io.github.talelin.latticy.model.my;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpuDetail extends Spu implements Serializable {

    private static final long serialVersionUID = 1970286571301783113L;
    /**
     * 当前 spu 所属分类
     */
    private String categoryName;
    /**
     * 当前商品的默认sku
     */
    private String defaultSku;
    /**
     * spu 轮播图集合
     */
    private List<String> rotationImgs;
    /**
     * spu 详情图集合
     */
    private List<String> spuDetailImgs;

}
