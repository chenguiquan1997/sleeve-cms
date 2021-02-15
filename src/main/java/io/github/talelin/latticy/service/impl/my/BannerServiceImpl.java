package io.github.talelin.latticy.service.impl.my;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.bo.my.BannerItemsBO;
import io.github.talelin.latticy.common.exception.DeleteException;

import io.github.talelin.latticy.common.exception.SaveException;
import io.github.talelin.latticy.common.exception.UpdateException;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.my.BannerDTO;
import io.github.talelin.latticy.mapper.my.BannerItemMapper;
import io.github.talelin.latticy.mapper.my.BannerMapper;
import io.github.talelin.latticy.model.my.Banner;
import io.github.talelin.latticy.model.my.BannerItem;
import io.github.talelin.latticy.service.imy.IBannerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements IBannerService {

    @Autowired
    private BannerMapper bannerMapper;

    @Autowired
    private BannerItemMapper bannerItemMapper;

    /**
     * 分页查询所有 Banner
     * @param page
     * @return
     */
    @Override
    public IPage<Banner> searchAllBanner(Page page) {
        /**
         * queryWrapper ：这个参数的作用是用来自定义SQL的，由于当前接口是查询所有的Banner，所以不需要
         * 传入这个参数
         */
        QueryWrapper<Banner> wrapper = new QueryWrapper<>();
        wrapper.isNull("delete_time");
        IPage<Banner> bannerIPage = bannerMapper.selectPage(page,wrapper);
        return bannerIPage;
    }

    /**
     * 根据 id 修改Banner
     * @param id
     * @param bannerDTO
     * @return
     */
    @Override
    public Integer updateBannerById(Long id, BannerDTO bannerDTO) {
        Banner banner = bannerMapper.selectById(id);
        if(banner == null) {
            throw new NotFoundException(20000);
        }
        BeanUtils.copyProperties(bannerDTO,banner);
        //修改成功，返回的结果为1,修改失败，返回结果0
        int result = bannerMapper.updateById(banner);
        if(result != 1) {
            throw new UpdateException(20001);
        }
        return result;
    }

    /**
     * 根据 id 删除 Banner
     * @param id
     */
    @Override
    public void removeBannerById(Long id) {
        Banner banner = bannerMapper.selectById(id);
        if(banner == null) {
            throw new NotFoundException(20000);
        }
        try{
            bannerMapper.removeBannerById(id);
        }catch (Exception e) {
            throw new DeleteException(21002);
        }
    }

    /**
     * 根据 BannerId, 查询 Banner 所属的 BannerItems
     * @param bannerId
     * @return
     */
    @Override
    public BannerItemsBO searchBannerItems(Long bannerId) {
        Banner banner = bannerMapper.selectById(bannerId);
        if(banner == null) {
            throw new NotFoundException(20000);
        }
        QueryWrapper<BannerItem> wrapper = new QueryWrapper<>();
        wrapper.eq("banner_id",bannerId).isNull("delete_time");
        List<BannerItem> bannerItemList =  bannerItemMapper.selectList(wrapper);
        return new BannerItemsBO(banner,bannerItemList);
    }

    /**
     * 新增 Banner
     * @param banner
     */
    @Override
    public void saveBanner(Banner banner) {
        //返回 1，创建成功
        try{
            bannerMapper.insert(banner);
        }catch (DuplicateKeyException e) {
            throw new SaveException(20004);
        }catch (Exception e) {
            throw new SaveException(21001);
        }
        return;
    }
}
