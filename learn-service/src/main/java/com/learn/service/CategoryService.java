package com.learn.service;

import com.learn.pojo.Category;
import com.learn.pojo.vo.CategoryVO;
import com.learn.pojo.vo.NewItemsVO;

import java.util.List;

public interface CategoryService {

    //查询所有一级分类
    public List<Category> queryAllRootLevelCat();

    public List<CategoryVO> getSubCatList(Integer rootCatId);

    public List<NewItemsVO> getSixNewItemsLazy(Integer rootCatId);
}
