package io.github.talelin.latticy.model.my;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpecKey extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -5349274517606575017L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 规格名
     */
    private String name;
    /**
     * 是否为标准规格
     */
    private Boolean standard;
    /**
     * 当前规格的单位，例：个，英寸
     */
    private String unit;
    /**
     * 规格描述
     */
    private String description;
}
