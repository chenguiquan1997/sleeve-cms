package io.github.talelin.latticy.service.impl.my;

import io.github.talelin.latticy.mapper.my.SkuMapper;
import io.github.talelin.latticy.service.imy.ISkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.github.talelin.latticy.model.my.Sku;

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
    public List<Sku> searchSkuListBySpuId(Long spuId) {
        return skuMapper.searchSkuListBySpuId(spuId);
    }
}
