package io.github.talelin.latticy.service.impl.my;

import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.common.exception.UpdateException;
import io.github.talelin.latticy.mapper.my.BannerItemMapper;
import io.github.talelin.latticy.model.my.BannerItem;
import io.github.talelin.latticy.service.imy.IBannerItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerItemServiceImpl implements IBannerItemService {

    @Autowired
    private BannerItemMapper bannerItemMapper;

    @Override
    public boolean updateById(Long id, BannerItem bannerItem) {
        BannerItem item = bannerItemMapper.selectById(id);
        if(item == null) {
            throw new NotFoundException(20002);
        }
        Integer res = bannerItemMapper.updateById(bannerItem);
        if(res != 1) {
            throw new UpdateException(20003);
        }
        return true;
    }

    @Override
    public boolean save(BannerItem bannerItem) {
        return false;
    }

    @Override
    public boolean remove(Long id) {
        return false;
    }
}
