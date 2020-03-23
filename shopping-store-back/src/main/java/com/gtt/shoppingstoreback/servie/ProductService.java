package com.gtt.shoppingstoreback.servie;

import com.github.pagehelper.Page;
import com.gtt.shoppingstoreback.dto.in.ProductSearchIn;
import com.gtt.shoppingstoreback.dto.out.PageOut;
import com.gtt.shoppingstoreback.dto.out.ProductListOut;
import com.gtt.shoppingstoreback.dto.out.ProductShowOut;
import com.gtt.shoppingstoreback.po.Product;

public interface ProductService {
    ProductShowOut getById(Integer productId);
    Page<ProductListOut> search(ProductSearchIn productSearchIn,Integer pageNum);
}
