package io.github.talelin.latticy.service.imy;

import io.github.talelin.latticy.dto.my.MinUserDTO;

/**
 * @Author Guiquan Chen
 * @Date 2021/5/31 11:31
 * @Version 1.0
 */
public interface IMinUserService {

    /**
     * 保存用户信息
     * @param minUserDTO
     */
    void save(MinUserDTO minUserDTO);

    boolean searchMinUserByName(String nickName);

    // void searchAllByPage();
}
