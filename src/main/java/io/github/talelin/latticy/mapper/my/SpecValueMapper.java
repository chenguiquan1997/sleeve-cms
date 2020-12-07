package io.github.talelin.latticy.mapper.my;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.model.my.SpecValue;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecValueMapper extends BaseMapper<SpecValue> {

    /**
     * 根据规格名id，分页查询对应的规格值
     * @param keyId
     */
    IPage<SpecValue> searchAllSpecValueByKey(IPage<SpecValue> page, @Param("keyId") Long keyId);
}
