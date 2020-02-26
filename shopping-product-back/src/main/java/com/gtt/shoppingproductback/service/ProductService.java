package com.gtt.shoppingproductback.service;

import com.github.pagehelper.Page;
import com.gtt.shoppingproductback.dto.in.ProductCreateIn;
import com.gtt.shoppingproductback.dto.in.ProductUpdateIn;
import com.gtt.shoppingproductback.dto.out.PageOut;
import com.gtt.shoppingproductback.dto.out.ProductListOut;
import com.gtt.shoppingproductback.dto.out.ProductShowOut;

import java.util.List;

public interface ProductService {

    Integer create(ProductCreateIn productCreateIn);
    void update(ProductUpdateIn productUpdateIn);
    void delete(Integer productId);
    void betchDelete(List<Integer> productIds);

    Page<ProductListOut> search(Integer pageNum);

    ProductShowOut getById(Integer productId);
}
