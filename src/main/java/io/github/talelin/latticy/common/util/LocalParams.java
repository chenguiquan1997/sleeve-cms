package io.github.talelin.latticy.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Guiquan Chen
 * @Date 2021/5/11 16:03
 * @Version 1.0
 * 存储当前线程的请求参数
 */
public class LocalParams {

    private static ThreadLocal<Map<String,String>> threadLocalParams = new ThreadLocal<>();

    public static void setParams(String param) {
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("param",param);
        threadLocalParams.set(paramMap);
    }

    public static String getParams() {
       return threadLocalParams.get().get("param");
    }

    public static void removeParams() {
        threadLocalParams.remove();
    }
}
