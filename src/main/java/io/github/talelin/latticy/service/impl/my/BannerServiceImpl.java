package io.github.talelin.latticy.service.impl.my;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.bo.BannerItemsBO;
import io.github.talelin.latticy.common.exception.UpdateException;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.BannerDTO;
import io.github.talelin.latticy.mapper.my.BannerItemMapper;
import io.github.talelin.latticy.mapper.my.BannerMapper;
import io.github.talelin.latticy.model.my.Banner;
import io.github.talelin.latticy.model.my.BannerItem;
import io.github.talelin.latticy.service.imy.IBannerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements IBannerService {

    @Autowired
    private BannerMapper bannerMapper;

    @Autowired
    private BannerItemMapper bannerItemMapper;

    /**
     * 分页查询所有Banner
     * @param page
     * @return
     */
    @Override
    public IPage<Banner> searchAllBanner(Page page) {
        /**
         * queryWrapper ：这个参数的作用是用来自定义SQL的，由于当前接口是查询所有的Banner，所以不需要
         * 传入这个参数
         */
        IPage<Banner> bannerIPage = bannerMapper.selectPage(page,null);
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
        //System.out.println("返回结果："+result);
        if(result != 1) {
            throw new UpdateException(20001);
        }
        return result;
    }

    /**
     * 根据id 删除Banner
     * @param id
     */
    @Override
    public void removeBannerById(Long id) {
        Banner banner = bannerMapper.selectById(id);
        if(banner == null) {
            throw new NotFoundException(20000);
        }
        bannerMapper.deleteById(id);
    }

    /**
     * 根据BannerId, 查询Banner所属的BannerItems
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
        wrapper.eq("banner_id",bannerId);
        List<BannerItem> bannerItemList =  bannerItemMapper.selectList(wrapper);
        return new BannerItemsBO(banner,bannerItemList);
    }

    /**
     * 新增Banner
     * @param banner
     */
    @Override
    public Integer saveBanner(Banner banner) {
        //返回 1，创建成功
        int res = bannerMapper.insert(banner);
        return res;
    }


}
