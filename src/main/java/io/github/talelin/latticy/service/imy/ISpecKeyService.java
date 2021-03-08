package io.github.talelin.latticy.service.imy;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.dto.my.SpecKeyDTO;
import io.github.talelin.latticy.dto.my.SpecKeyUpdateDTO;
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
     * @param specKeyDTO
     */
    void save(SpecKeyDTO specKeyDTO);

    /**
     * 根据id查询规格名
     * @param id
     * @return
     */
    SpecKey searchOneById(Long id);

    /**
     * 更新规格名
     * @param specKeyUpdateDTO
     */
    void update(SpecKeyUpdateDTO  specKeyUpdateDTO);
}
