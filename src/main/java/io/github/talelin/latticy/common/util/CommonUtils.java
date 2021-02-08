package io.github.talelin.latticy.common.util;

import io.github.talelin.latticy.vo.my.SkuOutlineVO;
import io.github.talelin.latticy.vo.my.SpuOutlineVO;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    /**
     * 将分页的页码-1
     * @param page
     * @return
     */
    public static Integer pageBefore(Integer page) {
       return page - 1;
    }

    /**
     * 将分页的页码+1
     * @param page
     * @return
     */
    public static Integer pageAfter(Integer page) {
        return page +1;
    }

    /**
     * 将SpuOutline转换成SpuOutlineVO
     * @param items
     * @return
     */
    public static List convertToSpuOutlineVO(List items)  {
        if(items == null || items.size() < 1) return null;
        List newItems = new ArrayList<>();
        items.forEach(item ->{
            SpuOutlineVO spuOutlineVO = new SpuOutlineVO<>();
            BeanUtils.copyProperties(item,spuOutlineVO);
            newItems.add(spuOutlineVO);
        });
        return newItems;
    }

    /**
     * 将sku 转换成SkuVO
     * @param items
     * @return
     */
    public static List convertToSkuOutLineVO(List<Map<Long,String>> items) {
        List newItems = new ArrayList<>();
        if(items == null || items.size() < 1) return newItems;
        items.forEach(item -> {
            SkuOutlineVO vo = new SkuOutlineVO();
            String title = item.get("title");
            newItems.add(title);
        });
        return newItems;
    }
}
