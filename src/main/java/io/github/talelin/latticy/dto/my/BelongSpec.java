package io.github.talelin.latticy.dto.my;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Guiquan Chen
 * @Date 2021/4/21 18:25
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BelongSpec {

    private Long keyId;

    private String keyName;

    private Long valueId;

    private String valueName;

}
