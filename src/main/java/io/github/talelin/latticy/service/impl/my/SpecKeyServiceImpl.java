package io.github.talelin.latticy.service.impl.my;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.common.exception.DeleteException;
import io.github.talelin.latticy.common.exception.SaveException;
import io.github.talelin.latticy.common.exception.UpdateException;
import io.github.talelin.latticy.dto.my.SpecKeyDTO;
import io.github.talelin.latticy.dto.my.SpecKeyUpdateDTO;
import io.github.talelin.latticy.mapper.my.SpecKeyMapper;
import io.github.talelin.latticy.model.my.SpecKey;
import io.github.talelin.latticy.model.my.SpecValue;
import io.github.talelin.latticy.service.imy.ISpecKeyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
     * 判断当前规格是否已经存在
     * @return
     */
    private boolean isAlreadyExist(String keyName) {
        List<String> specKeyList = specKeyMapper.searchSpecNameList();
        if(specKeyList == null || specKeyList.size() < 1) {
            throw new NotFoundException(23005);
        }
        for(String key: specKeyList) {
          if(keyName.equals(key)) {
              return false;
          }
        }
        return true;
    }

    /**
     * 新增规格名
     * @param specKeyDTO
     */
    @Override
    public void save(SpecKeyDTO specKeyDTO) {
        boolean flag = this.isAlreadyExist(specKeyDTO.getName());
        if(!flag) {
            throw new SaveException(23003);
        }
        SpecKey specKey = new SpecKey();
        BeanUtils.copyProperties(specKeyDTO,specKey);
        try{
            specKeyMapper.insert(specKey);
        }catch (Exception e) {
            throw new SaveException(21001);
        }
    }

    /**
     * 根据id查询规格名
     * @param id
     * @return
     */
    @Override
    public SpecKey searchOneById(Long id) {
        QueryWrapper<SpecKey> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id).isNull("delete_time");
        SpecKey specKey = specKeyMapper.selectOne(wrapper);
        if(specKey == null) {
            throw new NotFoundException(23001);
        }
        return specKey;
    }

    /**
     * 更新规格名
     * @param specKeyUpdateDTO
     */
    @Override
    public void update(SpecKeyUpdateDTO specKeyUpdateDTO) {
        SpecKey s = specKeyMapper.selectById(specKeyUpdateDTO.getId());
        if(s == null) {
           throw new NotFoundException(23001);
        }
        SpecKey specKey = new SpecKey();
        BeanUtils.copyProperties(specKeyUpdateDTO,specKey);
        try {
            specKeyMapper.updateById(specKey);
        }catch (Exception e) {
            throw new UpdateException(21000);
        }
    }

    /**
     * 根据id，删除指定规格
     * @param id 规格id
     */
    @Override
    public void delete(Long id) {
        this.searchOneById(id);
        SpecKey specKey = new SpecKey();
        specKey.setId(id);
        specKey.setDeleteTime(new Date());
        try {
            specKeyMapper.updateById(specKey);
        }catch (Exception  e) {
            throw new DeleteException(21002);
        }

    }

    /**
     * 获取简要规格信息
     * @return
     */
    @Override
    public List<SpecKey> getSpecSummary() {
        QueryWrapper<SpecKey> wrapper = new QueryWrapper<>();
        wrapper.isNull("delete_time");
        List<SpecKey> specKeys = specKeyMapper.selectList(wrapper);
        return specKeys;
    }

    /**
     * 根据一组id，获取简要规格信息
     * @param ids
     * @return
     */
    @Override
    public List<SpecKey> getSpecSummaryByIds(String ids) {
        QueryWrapper<SpecKey> wrapper = new QueryWrapper<>();
        wrapper.inSql("id",ids).isNull("delete_time");
        List<SpecKey> specKeys = specKeyMapper.selectList(wrapper);
        return specKeys;
    }
}
