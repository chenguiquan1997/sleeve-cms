package io.github.talelin.latticy.bo.my;

import io.github.talelin.latticy.model.my.MinUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Guiquan Chen
 * @Date 2021/5/31 17:10
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MinUserBO {

    private Long id;

    private String nickName;

    private Integer gender;

    private String city;

    private String province;

    private String country;

    private String avatarUrl;

    private Date createTime;

    public static List<MinUserBO> convert(List<MinUser> minUsers) {
        List<MinUserBO> minUserBOS = new ArrayList<>();
        if(minUsers == null || minUsers.size() < 1) return minUserBOS;
        minUsers.forEach(minUser -> {
            MinUserBO minUserBO = new MinUserBO();
            BeanUtils.copyProperties(minUser,minUserBO);
            minUserBOS.add(minUserBO);
        });
        return minUserBOS;
    }
}
