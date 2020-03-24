package com.imooc.sell.repository;

import com.imooc.sell.dataobject.ProductCategory;
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
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void createTest() {
//        ProductCategory productCategory = new ProductCategory("JAVA速成", 88);
//        ProductCategory result = repository.save(productCategory);
//        Assert.assertNotNull(result);
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryType(77);
        productCategory.setCategoryName("升职加薪");
        ProductCategory result = repository.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void findTest() {
        ProductCategory productCategory = repository.findOne(1);
        Assert.assertNotNull(productCategory);
        Assert.assertEquals(productCategory.getCategoryName(), "男生最爱");
    }

    @Test
    public void updateTest() {
        ProductCategory productCategory = repository.findOne(1);
        productCategory.setCategoryName("男生最爱-修正版3");
        ProductCategory updateProductCategory = repository.save(productCategory);
        Assert.assertNotNull(updateProductCategory);
    }

    @Test
    public void deleteTest() {
        ProductCategory productCategory = repository.findOne(9);
        Assert.assertNotNull(productCategory);
        repository.delete(9);
        ProductCategory deleteProductCategory = repository.findOne(9);
        Assert.assertNull(deleteProductCategory);
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> categoryList = Arrays.asList(1, 3, 5, 7, 9);
        List<ProductCategory> productCategories = repository.findByCategoryTypeIn(categoryList);
        Assert.assertEquals(productCategories.size(), 2);
    }
}