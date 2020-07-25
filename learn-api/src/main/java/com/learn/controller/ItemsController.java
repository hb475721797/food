package com.learn.controller;

import com.learn.enums.YesOrNo;
import com.learn.pojo.*;
import com.learn.pojo.vo.CategoryVO;
import com.learn.pojo.vo.CommentLevelCountsVO;
import com.learn.pojo.vo.ItemInfoVO;
import com.learn.pojo.vo.NewItemsVO;
import com.learn.service.CarouselService;
import com.learn.service.CategoryService;
import com.learn.service.ItemService;
import com.learn.utils.IMOOCJSONResult;
import com.learn.utils.PagedGridResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(value = "商品接口", tags = {"商品信息展示的相关接口"})
@RestController
@RequestMapping("items")
public class ItemsController extends BaseController {

    @Autowired
    private ItemService itemService;


    @ApiOperation(value = "查询商品详情", notes = "查询商品详情", httpMethod = "GET")
    @GetMapping("/info/{itemId}")
    public IMOOCJSONResult info(@ApiParam(name = "itemId", value = "商品id", required = true) @PathVariable String itemId) {
        if (itemId == null) {
            return IMOOCJSONResult.errorMsg("");
        }

        Items items = itemService.queryItemById(itemId);
        List<ItemsImg> itemsImgList = itemService.queryItemImgList(itemId);
        List<ItemsSpec> itemsSpecList = itemService.queryItemSpecList(itemId);
        ItemsParam itemsParam = itemService.queryItemParam(itemId);

        ItemInfoVO itemInfoVO = new ItemInfoVO();
        itemInfoVO.setItem(items);
        itemInfoVO.setItemImgList(itemsImgList);
        itemInfoVO.setItemSpecList(itemsSpecList);
        itemInfoVO.setItemParams(itemsParam);

        return IMOOCJSONResult.ok(itemInfoVO);
    }

    @ApiOperation(value = "查询商品评价等级", notes = "查询商品评价等级", httpMethod = "GET")
    @GetMapping("/commentLevel")
    public IMOOCJSONResult commentLevel(@ApiParam(name = "itemId", value = "商品id", required = true) @RequestParam String itemId) {
        if (itemId == null) {
            return IMOOCJSONResult.errorMsg("");
        }

        CommentLevelCountsVO countsVO = itemService.queryCommentCounts(itemId);
        return IMOOCJSONResult.ok(countsVO);
    }

    @ApiOperation(value = "查询商品评价分页", notes = "查询商品评价分页", httpMethod = "GET")
    @GetMapping("/comments")
    public IMOOCJSONResult comments(
            @ApiParam(name = "itemId", value = "商品id", required = true) @RequestParam String itemId,
            @ApiParam(name = "level", value = "评价等级", required = false) @RequestParam Integer level,
            @ApiParam(name = "page", value = "查询页数", required = false) @RequestParam Integer page,
            @ApiParam(name = "pageSize", value = "分页的每一页显示数量", required = false) @RequestParam Integer pageSize
    ) {
        if (itemId == null) {
            return IMOOCJSONResult.errorMsg("");
        }

        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = COMMENT_PAGE_SIZE;
        }

        PagedGridResult grid = itemService.queryPagedComments(itemId, level, page, pageSize);
        return IMOOCJSONResult.ok(grid);
    }


}
