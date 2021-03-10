package io.github.talelin.latticy.service.impl.my;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.common.exception.DeleteException;
import io.github.talelin.latticy.common.exception.SaveException;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.common.exception.UpdateException;
import io.github.talelin.latticy.dto.my.SpecValueDTO;
import io.github.talelin.latticy.dto.my.SpecValueUpdateDTO;
import io.github.talelin.latticy.mapper.my.SpecValueMapper;
import io.github.talelin.latticy.model.my.SpecValue;
import io.github.talelin.latticy.service.imy.ISpecValueService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SpecValueServiceImpl implements ISpecValueService {

    @Autowired
    private SpecValueMapper specValueMapper;

    /**
     * 根据id, 查询指定规格值的桩代码
     * @param id
     * @return
     */
    public Boolean searchSpecValueMock(Long id) {
        Wrapper<SpecValue> wrapper = new QueryWrapper<>();
        ((QueryWrapper<SpecValue>) wrapper).eq("id",id).isNull("delete_time");
        SpecValue specValue = specValueMapper.selectOne(wrapper);
        if(specValue == null) return false;
        return true;
    }

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
     * @param specValueDTO
     */
    @Override
    public void save(SpecValueDTO specValueDTO) {
        boolean exist = this.isAlreadyExistBySave(specValueDTO.getValue());
        if(!exist) {
            throw new SaveException(23003);
        }
        SpecValue specValue = new SpecValue();
        BeanUtils.copyProperties(specValueDTO,specValue);
        try{
            specValueMapper.insert(specValue);
        }catch (Exception e) {
            throw new SaveException(21001);
        }

    }

    /**
     * 保存规格值时，判断当前规格值名称是否存在
     * @param value 规格值名称
     * @return
     */
    private boolean isAlreadyExistBySave(String value) {
        List<SpecValue> specValues = specValueMapper.searchNameList();
        // 表示当前数据表中还没有规格值
        if(specValues.size() < 1) {
            return true;
        }
        List<String> nameList = new ArrayList<>();
        for(SpecValue s: specValues) {
            nameList.add(s.getValue());
        }
        for(String name : nameList) {
            if(name.equals(value)) {
                return false;
            }
        }
        return true;
    }
    /**
     * @Description: 修改规格值时，判断当前规格值名称是否存在
     * @param valueId 规格值id
     * @param value 规格值名称
     * @return boolean
     * @Author: Guiquan Chen
     * @Date: 2021/3/8
     */
    private boolean isAlreadyExistByUpdate(Long valueId, String value) {
        List<SpecValue> specValues = specValueMapper.searchNameList();
        // 表示当前数据表中还没有规格值
        if(specValues.size() < 1) {
            return true;
        }
        List<String> nameList = new ArrayList<>();
        // 将自己去掉
        for(SpecValue s: specValues)  {
           if(s.getId() == valueId) {
               continue;
           }
           nameList.add(s.getValue());
        }
        //判断是否有重复
        for(String name : nameList) {
            if(name.equals(value)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 更新规格值
     * @param specValueUpdateDTO
     */
    @Override
    public void update(SpecValueUpdateDTO specValueUpdateDTO) {
        boolean flag = this.searchSpecValueMock(specValueUpdateDTO.getId());
        if(!flag) {
            throw new NotFoundException(23002);
        }
        boolean exist = this.isAlreadyExistByUpdate(specValueUpdateDTO.getId(),specValueUpdateDTO.getValue());
        if(!exist) {
            throw new UpdateException(23003);
        }
        SpecValue specValue = new SpecValue();
        BeanUtils.copyProperties(specValueUpdateDTO,specValue);
        try {
            specValueMapper.updateById(specValue);
        }catch (Exception e) {
            throw new UpdateException(21000);
        }
    }

    /**
     * 获取指定规格值
     * @param id 规格值id
     * @return
     */
    @Override
    public SpecValue getValueById(Long id) {
        SpecValue specValue = specValueMapper.selectById(id);
        if(specValue == null) {
            throw new NotFoundException(23002);
        }
        return specValue;
    }

    /**
     * 删除指定规格值
     * @param id 规格值id
     */
    @Override
    public void delete(Long id) {
        boolean flag = this.searchSpecValueMock(id);
        if(!flag) {
            throw new NotFoundException(23002);
        }
        SpecValue specValue = new SpecValue().builder().id(id).build();
        specValue.setDeleteTime(new Date());
        try{
            specValueMapper.updateById(specValue);
        }catch (Exception e) {
           throw new DeleteException(21002);
        }

    }
}
