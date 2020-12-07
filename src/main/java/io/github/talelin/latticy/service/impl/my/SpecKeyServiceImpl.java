package io.github.talelin.latticy.service.impl.my;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.common.exception.SaveException;
import io.github.talelin.latticy.mapper.my.SpecKeyMapper;
import io.github.talelin.latticy.model.my.SpecKey;
import io.github.talelin.latticy.service.imy.ISpecKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecKeyServiceImpl implements ISpecKeyService {

    @Autowired
    private SpecKeyMapper specKeyMapper;

    /**
     * 分页查询规格名
     * @param page 当前页码
     * @param count 需要查询记录数量
     * @return 分页对象
     */
    @Override
    public IPage<SpecKey> searchAllSpecKey(Integer page, Integer count) {
        IPage<SpecKey> pager = new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(page,count);
        //分页返回的对象与传入的对象是同一个
        IPage<SpecKey> specKeys = specKeyMapper.searchAllSpecKey(pager);
        return specKeys;
    }

    /**
     * 新增规格名
     * @param specKey
     */
    @Override
    public void save(SpecKey specKey) {
        try{
            specKeyMapper.insert(specKey);
        }catch (Exception e) {
            throw new SaveException(21001);
        }
    }


}
