package com.gtt.shoppingstoreback.servie;

import com.gtt.shoppingstoreback.po.ProductOperation;

import java.util.List;

public interface ProductOperationService {

    void count(Integer productId);

    List<ProductOperation> selectHotProduct();
}
