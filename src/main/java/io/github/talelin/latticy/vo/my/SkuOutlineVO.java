package io.github.talelin.latticy.vo.my;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkuOutlineVO {

    /**
     * id
     */
    private Long id;
    /**
     * 当前sku 名
     */
    private String title;
}
