package io.github.talelin.latticy.vo.my;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SkuOutlineVO {

    /**
     * id
     */
    private Long id;
    /**
     * 当前sku 名
     */
    private String title;

    /**
     * 将sku 转换成SkuVO
     * @param items
     * @return
     */
    public static List convertToSkuOutLineVO(List<Map<Long,String>> items) {
        List<SkuOutlineVO> newItems = new ArrayList<>();
        if(items == null || items.size() < 1) return newItems;
        items.forEach(item -> {
//            SkuOutlineVO vo = SkuOutlineVO.builder()
//                                          .id(item.get("id"))
//                                          .title(item.get("title")).build();
        });
        return newItems;
    }
}
