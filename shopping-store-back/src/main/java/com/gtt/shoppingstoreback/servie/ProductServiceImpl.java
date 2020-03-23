package com.gtt.shoppingstoreback.servie;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gtt.shoppingstoreback.dao.ProductDetailMapper;
import com.gtt.shoppingstoreback.dao.ProductMapper;
import com.gtt.shoppingstoreback.dto.in.ProductSearchIn;
import com.gtt.shoppingstoreback.dto.out.PageOut;
import com.gtt.shoppingstoreback.dto.out.ProductListOut;
import com.gtt.shoppingstoreback.dto.out.ProductShowOut;
import com.gtt.shoppingstoreback.enumeration.ProductStatus;
import com.gtt.shoppingstoreback.po.Product;
import com.gtt.shoppingstoreback.po.ProductDetail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;
    @Resource
    private ProductDetailMapper productDetailMapper;
    @Override
    public ProductShowOut getById(Integer productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        ProductDetail productDetail = productDetailMapper.selectByPrimaryKey(productId);

        ProductShowOut productShowOut = new ProductShowOut();
        productShowOut.setProductId(product.getProductId());
        productShowOut.setProductCode(product.getProductCode());
        productShowOut.setProductName(product.getProductName());
        productShowOut.setDiscount(product.getDiscount());
        productShowOut.setPrice(product.getPrice());
        productShowOut.setMianPicUrl(product.getMainPicUrl());
        productShowOut.setRewordPoints(product.getRewordPoints());
        productShowOut.setStockQuantity(product.getStockQuantity());

        productShowOut.setDescription(productDetail.getDescription());
        String otherPicUrls = productDetail.getOtherPicUrls();
        List<String> otherPics = JSON.parseArray(otherPicUrls, String.class);
        productShowOut.setOtherPicUrls(otherPics);

        return productShowOut;
    }



    @Override
    public Page<ProductListOut> search(ProductSearchIn productSearchIn,Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        Page<ProductListOut> search = productMapper.search(productSearchIn.getKeyword(),(byte) ProductStatus.OnSales.ordinal());
        return search;
    }
}
