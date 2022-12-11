package com.soft.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.common.PageInfo;
import com.soft.common.ResponseResult;
import com.soft.mapper.ItemsCommentsMapper;
import com.soft.mapper.ItemsMapper;
import com.soft.pojo.Items;
import com.soft.pojo.ItemsComments;
import com.soft.pojo.VO.ItemCommentVO;
import com.soft.pojo.VO.ItemInfoVO;
import com.soft.pojo.VO.KeywordVO;
import com.soft.pojo.VO.ShopCatVO;
import com.soft.service.IItemsService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 商品表 商品信息相关表：分类表，商品图片表，商品规格表，商品参数表 服务实现类
 * </p>
 *
 * @author Mengyuan Guo
 * @since 2021-10-20
 */
@Service
public class ItemsServiceImpl extends ServiceImpl<ItemsMapper, Items> implements IItemsService {

    @Resource
    private ItemsMapper itemsMapper;

    @Resource
    private ItemsCommentsMapper itemsCommentsMapper;

    @Override
    public ResponseResult getItemInfo(String id) {
        if(StringUtils.isEmpty(id)) {
            return ResponseResult.errorResult(id);
        }
        ItemInfoVO itemInfo = itemsMapper.getItemInfo(id);
        return ResponseResult.successResult(itemInfo);
    }

    @Override
    public ResponseResult getItemComment(ItemsComments itemsComments) {
        Integer pageNum = itemsComments.getPageNum() == 0 ? 1 : itemsComments.getPageNum();
        Integer pageSize = itemsComments.getPageSize() == 0 ? 10 : itemsComments.getPageSize();
        Page page = new Page(pageNum, pageSize);
        Page<ItemCommentVO> itemComment = itemsCommentsMapper.getItemComment(page, itemsComments);
        PageInfo<ItemCommentVO> pageInfo = new PageInfo<>();
        pageInfo.setPageNum(Long.valueOf(itemComment.getCurrent()).intValue());
        pageInfo.setPageSize(Long.valueOf(itemComment.getSize()).intValue());
        pageInfo.setList(itemComment.getRecords());
        pageInfo.setTotal(itemComment.getTotal());

        return ResponseResult.successResult(pageInfo);
    }

    @Override
    public ResponseResult getCommentLevelNum(String id) {
        ItemCommentVO itemCommentVO = itemsMapper.getCommentLevelNum(id);
        return ResponseResult.successResult(itemCommentVO);
    }

    @Override
    public ResponseResult search(KeywordVO keywordVO) {
        Integer pageNum = keywordVO.getPageNum() == 0 ? 1 : keywordVO.getPageNum();
        Integer pageSize = keywordVO.getPageSize() == 0 ? 10 : keywordVO.getPageSize();
        Page page = new Page(pageNum, pageSize);
        IPage page1 = itemsMapper.search(page, keywordVO);

        PageInfo<Items> pageInfo = new PageInfo<>();
        pageInfo.setTotal(page1.getTotal());
        pageInfo.setPageNum(Long.valueOf(page1.getCurrent()).intValue());
        pageInfo.setPageSize(Long.valueOf(page1.getSize()).intValue());
        pageInfo.setList(page1.getRecords());
        return ResponseResult.successResult(pageInfo);
    }

    @Override
    public ResponseResult searchCategory(KeywordVO keywordVO) {
        if(StringUtils.isEmpty(keywordVO.getCatId())) {
            return ResponseResult.successResult("参数错误");
        }
        Integer pageNum = keywordVO.getPageNum() == 0 ? 1 : keywordVO.getPageNum();
        Integer pageSize = keywordVO.getPageSize() == 0 ? 10 : keywordVO.getPageSize();
        Page page = new Page(pageNum, pageSize);
        IPage page1 = itemsMapper.searchCategory(page, keywordVO);

        PageInfo<Items> pageInfo = new PageInfo<>();
        pageInfo.setTotal(page1.getTotal());
        pageInfo.setPageNum(Long.valueOf(page1.getCurrent()).intValue());
        pageInfo.setPageSize(Long.valueOf(page1.getSize()).intValue());
        pageInfo.setList(page1.getRecords());
        return ResponseResult.successResult(pageInfo);
    }

    @Override
    public List<ShopCatVO> getShopCatList(List<String> asList) {
        List<ShopCatVO> shopCatVOList = itemsMapper.getShopCatList(asList);
        return shopCatVOList;
    }


}
