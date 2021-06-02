package io.github.talelin.latticy.mapper.my;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.my.MinUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author Guiquan Chen
 * @Date 2021/5/31 11:25
 * @Version 1.0
 */
@Repository
public interface MinUserMapper extends BaseMapper<MinUser> {

    MinUser searchUserByNickName(@Param("nickName") String nickName);
}
