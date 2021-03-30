package io.github.talelin.latticy.model.my;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Guiquan Chen
 * @Date 2021/3/23 17:20
 * @Version 1.0
 * spu详情图片的实体类
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpuDetailImg extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -2647479462726874257L;
    /**
     * id
     */
    private Long id;
    /**
     * 详情图片 url
     */
    private String img;
    /**
     * 图片所属spu id
     */
    private Long spuId;
    /**
     * 图片排序，用于在用户端详情页，图片展示的顺序
     */
    private Integer idx;

    /**
     * 构造详情图对象
     * @param detailImgs 详情图 url 集合
     * @param spuId spu id
     * @return null 当详情图 url 集合为空时，返回 null
     * @return List<SpuDetailImg>
     */
    public static List<SpuDetailImg> contruct(List<String> detailImgs, Long spuId) {
        if(detailImgs == null || detailImgs.size() < 1) return null;
        int i = 0;
        List<SpuDetailImg> spuDetailImgs = new ArrayList<>();
        for(String img : detailImgs) {
            SpuDetailImg spuDetailImg = SpuDetailImg.builder()
                    .img(img)
                    .spuId(spuId)
                    .idx(++i).build();
            spuDetailImgs.add(spuDetailImg);
        }
        return spuDetailImgs;
    }
}
