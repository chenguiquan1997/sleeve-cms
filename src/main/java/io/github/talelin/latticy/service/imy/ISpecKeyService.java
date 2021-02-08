package io.github.talelin.latticy.service.imy;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.model.my.SpecKey;

public interface ISpecKeyService {

    /**
     * 分页查询规格名
     * @param page 当前页码
     * @param count 需要查询记录数量
     * @return
     */
    IPage<SpecKey> searchAllSpecKey(Integer page, Integer count);

    /**
     * 新增商品规格名
     * @param specKey
     */
    void save(SpecKey specKey);
}
