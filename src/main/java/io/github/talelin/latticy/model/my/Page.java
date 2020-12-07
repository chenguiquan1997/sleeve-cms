package io.github.talelin.latticy.model.my;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Page<T> {

    /**
     * 数据集总数
     */
    private Integer total;

    /**
     * 当前页数据集合
     */
    private T items;

    /**
     * 当前数据页
     */
    private Integer page;

    /**
     * 当前数据页中，数据总数
     * */
    private Integer count;
}
