package com.learn.service;


import com.learn.pojo.Items;
import com.learn.pojo.ItemsImg;
import com.learn.pojo.ItemsParam;
import com.learn.pojo.ItemsSpec;
import com.learn.pojo.vo.CommentLevelCountsVO;
import com.learn.pojo.vo.ItemCommentVO;
import com.learn.utils.PagedGridResult;

import java.util.List;

public interface ItemService {

    // 根据商品id查询详情
    public Items queryItemById(String id);

    // 根据商品id查询商品图片列表
    public List<ItemsImg> queryItemImgList(String itemId);

    // 根据商品id查询商品规格
    public List<ItemsSpec> queryItemSpecList(String itemId);

    // 根据商品id查询商品属性
    public ItemsParam queryItemParam(String itemId);

    // 根据商品id查询商品的评价等级数量
    public CommentLevelCountsVO queryCommentCounts(String itemId);

    // 根据商品id查询商品的评价（分页）
    public PagedGridResult queryPagedComments(String itemId, Integer level, Integer page, Integer pageSize);
}
