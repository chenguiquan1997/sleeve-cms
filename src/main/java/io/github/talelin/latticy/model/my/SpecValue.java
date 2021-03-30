package io.github.talelin.latticy.model.my;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SpecValue extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 4713319006358687657L;
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 规格值
     */
    private String value;
    /**
     * 规格名id
     */
    private Long keyId;
    /**
     * 扩展说明
     */
    private String extend;
}
