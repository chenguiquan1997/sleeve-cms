package io.github.talelin.latticy.service.impl.my;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.talelin.latticy.bo.my.SpuDetailBO;
import io.github.talelin.latticy.mapper.my.SpuMapper;
import io.github.talelin.latticy.model.my.SpuDetail;
import io.github.talelin.latticy.model.my.SpuOutline;
import io.github.talelin.latticy.service.imy.ISpuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class SpuServiceImpl implements ISpuService {

    @Autowired
    private SpuMapper spuMapper;

    /**
     * 分页查询Spu概要信息
     * @param page 页码
     * @param count 当前页记录数量
     * @return
     */
    @Override
    public IPage<SpuOutline> searchSpuOutline(Integer page, Integer count) {
        IPage<SpuOutline> pager = new Page<>(page,count);
        return spuMapper.searchSpuOutline(pager);
    }

    /**
     * 根据spuId查询商品详情
     * @param spuId
     * @return
     */
    @Override
    public SpuDetailBO searchSpuDetailById(Long spuId) {
        SpuDetail spuDetail = spuMapper.searchSpuDetailById(spuId);
        List<String> tagList = this.splitTags(spuDetail.getTags());
        List<Map<Object,Object>> specList = spuMapper.searchSpecBySpuId(spuId);
        SpuDetailBO spuDetailBO = new SpuDetailBO();
        spuDetailBO.convert(spuDetail,specList,tagList);
        return spuDetailBO;
    }
    /**
     * @Description: 拆分SPU的标签
     * @param tags
     * @return java.util.List<java.lang.String>
     * @Author: Guiquan Chen
     * @Date: 2021/3/10
     */
    private List<String> splitTags(String tags) {
       List<String> tagList = new ArrayList<>();
       if(tags.isEmpty()) return tagList;
       String[] tagArr = tags.split("\\$");
       return Arrays.asList(tagArr);
    }

    @Override
    public List<Map<Object, Object>> searchSpecBySpuId(Long spuId) {
        return null;
    }

}
