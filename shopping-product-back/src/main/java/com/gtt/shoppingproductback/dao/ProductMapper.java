package com.gtt.shoppingproductback.dao;

import com.github.pagehelper.Page;
import com.gtt.shoppingproductback.dto.out.ProductListOut;
import com.gtt.shoppingproductback.dto.out.ProductShowOut;
import com.gtt.shoppingproductback.po.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    Page<ProductListOut> search(Integer pageNum);

    ProductShowOut getById(Integer productId);

    void betchDelete(@Param("productIds")List<Integer> productIds);
}