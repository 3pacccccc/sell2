package com.imooc.sell.service.impl;

import com.imooc.sell.dataobject.ProductCategory;
import com.imooc.sell.service.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService service;

    @Test
    public void findOne() {
        Integer categoryId = 1;
        ProductCategory productCategory = service.findOne(categoryId);
        Assert.assertEquals(productCategory.getCategoryName(), "男生最爱-修正版3");
    }

    @Test
    public void findAll() {
        List<ProductCategory> productCategories = service.findAll();
        Assert.assertEquals(productCategories.size(), 8);
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> categoryTypeList = Arrays.asList(1,3,5,7,9);
        List<ProductCategory> productCategories = service.findByCategoryTypeIn(categoryTypeList);
        Assert.assertEquals(productCategories.size(), 2);
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryType(6);
        productCategory.setCategoryName("跳槽涨薪");
        ProductCategory result = service.save(productCategory);
        Assert.assertNotNull(result);
    }
}