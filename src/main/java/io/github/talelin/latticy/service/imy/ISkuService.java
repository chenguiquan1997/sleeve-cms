package io.github.talelin.latticy.service.imy;

import io.github.talelin.latticy.model.my.Sku;
import java.util.List;
import java.util.Map;

public interface ISkuService {

    /**
     * 根据spuid 查询所属Sku
     * @param spuId
     * @return
     */
    List<Sku> searchSkuListBySpuId(Long spuId);

}
