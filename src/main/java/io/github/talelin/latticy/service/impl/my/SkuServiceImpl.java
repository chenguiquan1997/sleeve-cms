package io.github.talelin.latticy.service.impl.my;

import io.github.talelin.latticy.mapper.my.SkuMapper;
import io.github.talelin.latticy.service.imy.ISkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SkuServiceImpl implements ISkuService {

    @Autowired
    private SkuMapper skuMapper;

    /**
     * 根据spuid 查询所属Sku
     * @param spuId
     * @return
     */
    @Override
    public List<Map<Long, String>> searchSkuListBySpuId(Long spuId) {
        return skuMapper.searchSkuListBySpuId(spuId);
    }
}
