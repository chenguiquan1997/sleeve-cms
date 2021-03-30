package io.github.talelin.latticy.service.imy;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.dto.my.SpecKeyDTO;
import io.github.talelin.latticy.dto.my.SpecKeyUpdateDTO;
import io.github.talelin.latticy.model.my.SpecKey;

import java.util.List;

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

    /**
     * 删除指定规格
     * @param id
     */
    void delete(Long id);

    /**
     * 获取简要规格信息
     * @return
     */
    List<SpecKey> getSpecSummary();

    /**
     * 根据一组id，获取简要规格信息
     * @param ids
     * @return
     */
    List<SpecKey> getSpecSummaryByIds(String ids);
}
