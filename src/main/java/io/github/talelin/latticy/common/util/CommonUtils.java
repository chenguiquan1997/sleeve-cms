package io.github.talelin.latticy.common.util;

import java.util.HashMap;
import java.util.Map;

public class CommonUtils {

    /**
     * 使用 Mybatis 进行分页查询时，用于分页参数转换的方法
     * @param page 需要查询的页码
     * @param size 每一页返回的数据
     * @return currPage:当前查询的页码，startCount:当前需要从第几条开始查询
     */
    public static Map<String,Integer> convertPageParams(Integer page, Integer size) {
        Map<String,Integer> pageMap = new HashMap<>();
        pageMap.put("currPage",page);
        pageMap.put("startCount",(page - 1) * size);
        return pageMap;
    }
}
