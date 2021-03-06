package com.gtt.shoppingproductback.dao;

import at.favre.lib.bytes.Bytes;
import com.github.pagehelper.Page;
import com.gtt.shoppingproductback.dto.out.ProductListOut;
import com.gtt.shoppingproductback.dto.out.ProductShowOut;
import com.gtt.shoppingproductback.po.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    Page<ProductListOut> search(@Param("productCode") String productCode, @Param("status") Byte status,@Param("stockQuantity") Integer stockQuantity,@Param("price") Double price,@Param("productName") String productName);

    ProductShowOut getById(Integer productId);

    void betchDelete(@Param("productIds")List<Integer> productIds);
}