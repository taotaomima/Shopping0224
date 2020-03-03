package com.gtt.shoppingstoreback.dao;

import com.github.pagehelper.Page;
import com.gtt.shoppingstoreback.dto.out.ProductListOut;
import com.gtt.shoppingstoreback.po.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);


    Page<ProductListOut> search();
}