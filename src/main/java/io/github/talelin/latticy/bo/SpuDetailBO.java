package io.github.talelin.latticy.bo;

import io.github.talelin.latticy.model.my.SpuDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * spu BO 模型类，用于Service 向 Controller 层返回数据
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpuDetailBO extends SpuDetail {
    /**
     * spu所拥有的规格
     */
    List<Map<Object,Object>> spuSpecs;

    public void convert(SpuDetail spuDetail, List<Map<Object,Object>> spuSpecs) {
        BeanUtils.copyProperties(spuDetail,this);
        this.spuSpecs = spuSpecs;
    }

}
