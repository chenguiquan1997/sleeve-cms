package io.github.talelin.latticy.service.imy;

import io.github.talelin.latticy.bo.my.MinUserBO;
import io.github.talelin.latticy.dto.my.MinUserDTO;
import io.github.talelin.latticy.model.my.Page;

import java.util.Map;

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

    Page<MinUserBO> searchAllByPage(Map<String,Integer> pageMap, Integer size);
}
