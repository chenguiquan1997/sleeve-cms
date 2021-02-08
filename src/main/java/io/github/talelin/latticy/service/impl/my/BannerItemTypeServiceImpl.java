package io.github.talelin.latticy.service.impl.my;

import io.github.talelin.latticy.mapper.my.BannerItemTypeMapper;
import io.github.talelin.latticy.model.my.BannerItemType;
import io.github.talelin.latticy.service.imy.IBannerItemService;
import io.github.talelin.latticy.service.imy.IBannerItemTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BannerItemTypeServiceImpl implements IBannerItemTypeService {

    @Autowired
    private BannerItemTypeMapper bannerItemTypeMapper;

    /**
     * 获取所有BannerItem 的类型
     * @return
     */
    @Override
    public List<Map<String,String>> searchAll() {
        List<BannerItemType> itemTypes = bannerItemTypeMapper.selectList(null);
        if(itemTypes.size() == 0) {
            return null;
        }
        List<Map<String,String>> typeList = new ArrayList<>();
        itemTypes.forEach(item -> {
            Map<String,String> map = new HashMap<>();
            map.put("value",item.getName());
            typeList.add(map);
        });
        return typeList;
    }
}
