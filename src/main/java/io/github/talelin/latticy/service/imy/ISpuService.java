package io.github.talelin.latticy.service.imy;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.bo.my.SpuDetailBO;
import io.github.talelin.latticy.dto.my.SpuSaveDTO;
import io.github.talelin.latticy.dto.my.SpuUpdateDTO;
import io.github.talelin.latticy.model.my.SpuOutline;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ISpuService {
    /**
     * 分页查询Spu概要信息
     * @param page 页码
     * @param count 当前页记录数量
     * @return
     */
    IPage<SpuOutline> searchSpuOutline(Integer page, Integer count);

    /**
     * 根据spuId查询商品详情
     * @param spuId
     * @return
     */
    SpuDetailBO searchSpuDetailById(Long spuId);

    /**
     * 根据spuId 查询当前spu所拥有的商品规格
     * @param spuId
     * @return
     */
    List<Map<Object,Object>> searchSpecBySpuId(Long spuId);

    /**
     * 更新 spu
     * @param spuUpdateDTO
     */
    void update(SpuUpdateDTO spuUpdateDTO);

    /**
     * 保存 spu
     * @param spuSaveDTO
     */
    void save(SpuSaveDTO spuSaveDTO);

    /**
     * 逻辑删除 spu
     * @param id
     */
    void removeSpuById(Long id);
}
