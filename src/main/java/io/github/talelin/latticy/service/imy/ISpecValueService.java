package io.github.talelin.latticy.service.imy;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.model.my.SpecValue;

public interface ISpecValueService {

    /**
     * 根据规格名id，分页查询对应的规格值
     * @param page
     * @param size
     * @param specKeyId 规格名id
     */
    IPage<SpecValue> searchAllSpecValueByKey(Integer page, Integer size, Long specKeyId);

    /**
     * 新增商品规格值
     * @param specValue
     */
    void save(SpecValue specValue);
}
