package io.github.talelin.latticy.model.my;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Banner实体类
 */
@Getter
@Setter
public class Banner extends BaseEntity implements Serializable {

    //当前类生成这个 UID 的目的是为了 在实体类进行序列化和反序列化的时候，验证版本是否一致
    private static final long serialVersionUID = 913652500225337503L;
    /**
     * mybatis-plus对于自动生成主键id,一共有5中类型。默认是“全局唯一”，所以我们要设置主键id的类型
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * banner 名称
     */
    private String name;
    /**
     * 标题
     */
    private String title;
    /**
     * 图片
     */
    private String img;
    /**
     * 描述
     */
    private String description;

}
