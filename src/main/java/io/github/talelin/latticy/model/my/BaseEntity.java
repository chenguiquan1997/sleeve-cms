package io.github.talelin.latticy.model.my;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import java.util.Date;

@Data
public class BaseEntity {

    private Date createTime;
    /**
     * 属性上如果使用了@JsonIgnore注解，在返回到前端的数据中，就不会有当前属性的数据
     * 但是需要注意：如果前端使用json的形式进行数据的提交，那么当前属性也依然接收不到数据
     * 这时，前端就需要使用form表单进行提交
     */
    @JsonIgnore
    private Date updateTime;

    @JsonIgnore
    private Date deleteTime;
}
