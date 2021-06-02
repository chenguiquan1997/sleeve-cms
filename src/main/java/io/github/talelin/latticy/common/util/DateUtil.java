package io.github.talelin.latticy.common.util;

import io.github.talelin.latticy.common.exception.ParamException;
import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author Guiquan Chen
 * @Date 2021/5/17 17:00
 * @Version 1.0
 */
@Slf4j
public class DateUtil {

    /**
     * 获取指定的时间对象
     * @param dateStr 时间字符串
     * @return 时间对象
     * @throws ParseException
     */
    public static Date getSpecifyDate(String dateStr){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
          return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            log.error("时间转换异常，date=[{}]",dateStr,e);
            throw new ParamException(26002);
        }
    }
}
