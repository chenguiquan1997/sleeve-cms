package io.github.talelin.latticy.service.imy;

import java.util.List;
import java.util.Map;

public interface ISkuService {

    /**
     * 根据spuid 查询所属Sku
     * @param spuId
     * @return
     */
    List<Map<Long,String>> searchSkuListBySpuId(Long spuId);
}
