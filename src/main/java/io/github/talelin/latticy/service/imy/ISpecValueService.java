package io.github.talelin.latticy.service.imy;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.dto.my.SpecValueDTO;
import io.github.talelin.latticy.dto.my.SpecValueUpdateDTO;
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
     * @param specValueDto
     */
    void save(SpecValueDTO specValueDto);

    /**
     * 更新规格值
     * @param specValueUpdateDTO
     */
    void update(SpecValueUpdateDTO specValueUpdateDTO);

    /**
     * 根据id，查询规格值
     * @param id
     * @return
     */
    SpecValue getValueById(Long id);

    /**
     * 根据id，删除规格值
     * @param id
     */
    void delete(Long id);
}
