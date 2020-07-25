package com.learn.service.impl;

import com.learn.enums.CateType;
import com.learn.mapper.CategoryMapper;
import com.learn.mapper.CategoryMapperCustom;
import com.learn.pojo.Category;
import com.learn.pojo.Users;
import com.learn.pojo.vo.CategoryVO;
import com.learn.pojo.vo.NewItemsVO;
import com.learn.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryMapperCustom categoryMapperCustom;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Category> queryAllRootLevelCat() {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type", CateType.CATE_TYPE_LEVEL_ONE.type);

        return categoryMapper.selectByExample(example);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<CategoryVO> getSubCatList(Integer rootCatId) {
        return categoryMapperCustom.getSubCatList(rootCatId);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<NewItemsVO> getSixNewItemsLazy(Integer rootCatId) {
        Map<String, Object> map = new HashMap<>();
        map.put("rootCatId", rootCatId);
        map.put("cateType", CateType.CATE_TYPE_LEVEL_ONE.type);
        return categoryMapperCustom.getSixNewItemsLazy(map);
    }
}
