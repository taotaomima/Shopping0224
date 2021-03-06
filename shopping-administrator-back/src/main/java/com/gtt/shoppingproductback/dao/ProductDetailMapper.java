package com.gtt.shoppingproductback.dao;

import com.gtt.shoppingproductback.po.ProductDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductDetailMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(ProductDetail record);

    int insertSelective(ProductDetail record);

    ProductDetail selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(ProductDetail record);

    int updateByPrimaryKeyWithBLOBs(ProductDetail record);

    int updateByPrimaryKey(ProductDetail record);

    void betchDelete(@Param("productIds") List<Integer> productIds);
}