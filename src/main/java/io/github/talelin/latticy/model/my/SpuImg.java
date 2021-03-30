package io.github.talelin.latticy.model.my;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Guiquan Chen
 * @Date 2021/3/23 16:38
 * @Version 1.0
 * 商品轮播图实体类
 */
@Data
@Builder
@AllArgsConstructor
public class SpuImg extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 3574164858594341645L;
    /**
     * id
     */
    private Long id;
    /**
     * 轮播图片 url
     */
    private String img;
    /**
     * 轮播图片所属 spu id
     */
    private Long spuId;

    /**
     * 构造轮播图对象
     * @param rotationImgs 轮播图 url 集合
     * @param spuId spu id
     * @return null 当轮播图 url 集合为空时，返回 null
     * @return List<SpuImg>
     */
    public static List<SpuImg> construct(List<String> rotationImgs,Long spuId) {
        if(rotationImgs == null || rotationImgs.size() < 1) return null;
        List<SpuImg>  spuImgs = new ArrayList<>();
        rotationImgs.forEach(img -> {
            SpuImg spuImg = SpuImg.builder()
                    .img(img)
                    .spuId(spuId)
                    .build();
            spuImgs.add(spuImg);
        });
        return spuImgs;
    }

}
