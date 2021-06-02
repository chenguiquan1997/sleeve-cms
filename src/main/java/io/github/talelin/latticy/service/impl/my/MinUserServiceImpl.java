package io.github.talelin.latticy.service.impl.my;

import io.github.talelin.latticy.common.exception.AddException;
import io.github.talelin.latticy.dto.my.MinUserDTO;
import io.github.talelin.latticy.mapper.my.MinUserMapper;
import io.github.talelin.latticy.model.my.MinUser;
import io.github.talelin.latticy.service.imy.IMinUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Guiquan Chen
 * @Date 2021/5/31 11:32
 * @Version 1.0
 */
@Service
@Slf4j
public class MinUserServiceImpl implements IMinUserService {

    @Autowired
    private MinUserMapper minUserMapper;

    /**
     * @Description: 注册用户
     * @param minUserDTO
     * @return: null
     * @Author: Guiquan Chen
     * @Date: 2021/5/31
     */
    @Override
    public void save(MinUserDTO minUserDTO) {
        MinUser minUser = new MinUser();
        BeanUtils.copyProperties(minUserDTO,minUser);
        try {
            minUserMapper.insert(minUser);
        }catch (Exception e) {
            log.error("用户注册失败 minUserDTO=[{}]",minUserDTO,e);
            throw new AddException(29001);
        }
    }

    @Override
    public boolean searchMinUserByName(String nickName) {
        MinUser user = minUserMapper.searchUserByNickName(nickName);
        if(user == null) return false;
        return true;
    }
}
