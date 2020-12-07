package io.github.talelin.latticy.service.impl.my;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.common.exception.SaveException;
import io.github.talelin.latticy.mapper.my.SpecValueMapper;
import io.github.talelin.latticy.model.my.SpecValue;
import io.github.talelin.latticy.service.imy.ISpecValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecValueServiceImpl implements ISpecValueService {

    @Autowired
    private SpecValueMapper specValueMapper;

    /**
     * 根据规格名id，分页查询对应的规格值
     * @param page
     * @param count
     * @param specKeyId
     */
    @Override
    public IPage<SpecValue> searchAllSpecValueByKey(Integer page, Integer count, Long specKeyId) {
        IPage<SpecValue> pager = new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(page,count);
        return specValueMapper.searchAllSpecValueByKey(pager,specKeyId);
    }

    /**
     * 新增规格值
     * @param specValue
     */
    @Override
    public void save(SpecValue specValue) {
        try{
            specValueMapper.insert(specValue);
        }catch (Exception e) {
            throw new SaveException(21001);
        }

    }
}
