package io.github.talelin.latticy.service.impl.my;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.autoconfigure.exception.ParameterException;
import io.github.talelin.latticy.common.exception.DeleteException;
import io.github.talelin.latticy.common.exception.SaveException;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.common.exception.UpdateException;
import io.github.talelin.latticy.dto.my.BannerItemDTO;
import io.github.talelin.latticy.mapper.my.BannerItemMapper;
import io.github.talelin.latticy.model.my.BannerItem;
import io.github.talelin.latticy.service.imy.IBannerItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerItemServiceImpl implements IBannerItemService {

    @Autowired
    private BannerItemMapper bannerItemMapper;

    /**
     * 根据id 更新指定 banner-item
     * @param id
     * @param bannerItemDTO
     * @return
     */
    @Override
    public boolean updateById(Long id, BannerItemDTO bannerItemDTO) {
        BannerItem item = new BannerItem();
        BeanUtils.copyProperties(bannerItemDTO,item);
        Integer type = item.getTypeByTypeName(item.getTypeName());
        item.setType(type);
        BannerItem item1 = bannerItemMapper.selectById(id);
        if(item1 == null) {
            throw new NotFoundException(20002);
        }
        Integer res = bannerItemMapper.updateById(item);
        if(res != 1) {
            throw new UpdateException(20003);
        }
        return true;
    }

    /**
     * 添加 banner-item
     * @param bannerItemDTO
     * @return
     */
    @Override
    public boolean save(BannerItemDTO bannerItemDTO) {
        BannerItem bannerItem = new BannerItem();
        BeanUtils.copyProperties(bannerItemDTO,bannerItem);
        int res = bannerItemMapper.insert(bannerItem);
        if(res != 1) {
            throw new SaveException(21003);
        }
        return true;
    }

    /**
     * 根据id 逻辑删除指定 banner-item
     * @param id
     */
    @Override
    public void remove(Long id) {
        if(id <= 0 || id == null) {
            throw new ParameterException(21005);
        }
        try {
            bannerItemMapper.removeItemById(id);
        }catch (Exception e) {
           throw new DeleteException(21002);
        }
    }

    /**
     * 根据 id 查询banner-item
     * @param id
     * @return
     */
    @Override
    public BannerItem searchOneById(Long id) {
        if(id <= 0 || id == null) {
            throw new NotFoundException(20002);
        }
        QueryWrapper<BannerItem> wrapper = new QueryWrapper<>();
        wrapper.isNull("delete_time").eq("id",id);
        BannerItem bannerItem = bannerItemMapper.selectOne(wrapper);
        if(bannerItem == null) {
            throw new NotFoundException(20002);
        }
        return bannerItem;
    }

}
