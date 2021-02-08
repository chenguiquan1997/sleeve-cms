package io.github.talelin.latticy.common.enumeration.my;

import java.util.List;
import java.util.stream.Stream;

/**
 * 当前枚举用于记录 BannerItem的类型
 */
public enum BannerItemTypeEnum {
    SPU(1,"商品"),
    THEME(2,"主题"),
    SPU_LIST(3,"商品列表")
    ;

    private Integer code;
    private String value;

    BannerItemTypeEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    /**
     * 通过code，获取对应的类型名称
     * @param itemCode
     * @return
     */
    public static BannerItemTypeEnum getType(Integer itemCode) {
        return Stream.of(BannerItemTypeEnum.values())
                .filter(t -> t.code == itemCode)
                .findAny().orElse(null);
    }

    /**
     * 通过typeName 获取code
     * @param typeName
     * @return
     */
    public static BannerItemTypeEnum getValue(String typeName) {
        //BannerItemTypeEnum.values() 获取所有的枚举值
        return Stream.of(BannerItemTypeEnum.values())
                .filter(t -> t.value.equals(typeName))
                .findAny().orElse(null);
    }

}
