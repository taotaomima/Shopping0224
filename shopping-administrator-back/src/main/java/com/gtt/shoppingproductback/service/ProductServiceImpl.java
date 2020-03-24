package com.gtt.shoppingproductback.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gtt.shoppingproductback.dao.ProductDetailMapper;
import com.gtt.shoppingproductback.dao.ProductMapper;
import com.gtt.shoppingproductback.dto.in.ProductCreateIn;
import com.gtt.shoppingproductback.dto.in.ProductSearchIn;
import com.gtt.shoppingproductback.dto.in.ProductUpdateIn;
import com.gtt.shoppingproductback.dto.out.ProductListOut;
import com.gtt.shoppingproductback.dto.out.ProductShowOut;
import com.gtt.shoppingproductback.es.doc.ProductDoc;
import com.gtt.shoppingproductback.es.repo.ProductElasticRepo;
import com.gtt.shoppingproductback.po.Product;
import com.gtt.shoppingproductback.po.ProductDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource//在mapper接口添加注解@respository
    private ProductMapper productMapper;
    @Resource
    private ProductDetailMapper productDetailMapper;

    @Autowired
    private ProductElasticRepo productElasticRepo;

    @Override
    @Transactional
    public Integer create(ProductCreateIn productCreateIn) {
        Product product = new Product();
        product.setProductCode(productCreateIn.getProductCode());
        product.setProductName(productCreateIn.getProductName());
        product.setPrice(productCreateIn.getPrice());
        product.setDiscount(productCreateIn.getDiscount());
        product.setStockQuantity(productCreateIn.getStockQuantity());
        product.setStatus(productCreateIn.getStatus());
        product.setMainPicUrl(productCreateIn.getMainPicUrl());
        product.setRewordPoints(productCreateIn.getRewordPoints());
        product.setSortOrder(productCreateIn.getSortOrder());
        String descripition = productCreateIn.getDescription();
        String productAbstract=descripition.substring(0, Math.min(100,descripition.length()));
        product.setProductAbstract(productAbstract);
        productMapper.insertSelective(product);

        Integer productId = product.getProductId();
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductId(productId);
        productDetail.setDescription(productCreateIn.getDescription());
        List<String> otherPic = productCreateIn.getOtherPic();
        productDetail.setOtherPicUrls(JSON.toJSONString(otherPic));
        productDetailMapper.insertSelective(productDetail);

        ProductDoc productDoc = new ProductDoc();
        productDoc.setProductId(productId);
        productDoc.setProductCode(productCreateIn.getProductCode());
        productDoc.setProductName(productCreateIn.getProductName());
        productDoc.setProductAbstract(productCreateIn.getDescription());
        productElasticRepo.save(productDoc)

        return productId;
    }

    @Override
    @Transactional
    public void update(ProductUpdateIn productUpdateIn) {
        Product product = new Product();
        product.setProductId(productUpdateIn.getProductId());
        product.setProductName(productUpdateIn.getProductName());
        product.setPrice(productUpdateIn.getPrice());
        product.setDiscount(productUpdateIn.getDiscount());
        product.setStockQuantity(productUpdateIn.getStockQuantity());
        product.setMainPicUrl(productUpdateIn.getMainPicUrl());
        product.setStatus(productUpdateIn.getStatus());
        product.setRewordPoints(productUpdateIn.getRewordPoints());
        product.setSortOrder(productUpdateIn.getSortOrder());
        String descripition = productUpdateIn.getDescription();
        String productAbstract=descripition.substring(0, Math.min(100,descripition.length()));
        product.setProductAbstract(productAbstract);
        productMapper.updateByPrimaryKeySelective(product);

        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductId(productUpdateIn.getProductId());
        productDetail.setDescription(productUpdateIn.getDescription());
        List<String> otherPic = productUpdateIn.getOtherPic();
        productDetail.setOtherPicUrls(JSON.toJSONString(otherPic));
        productDetailMapper.updateByPrimaryKeySelective(productDetail);
    }

    @Override
    @Transactional
    public void delete(Integer productId) {
       productDetailMapper.deleteByPrimaryKey(productId);
       productMapper.deleteByPrimaryKey(productId);
    }

    @Override
    @Transactional
    public void betchDelete(List<Integer> productIds) {
        productMapper.betchDelete(productIds);
        productDetailMapper.betchDelete(productIds);
    }

    @Override
    public Page<ProductListOut> search(Integer pageNum, ProductSearchIn productSearchIn) {
        PageHelper.startPage(pageNum,10);
        Page<ProductListOut> page=productMapper.search(productSearchIn.getProductCode(),productSearchIn.getStatus(),
                productSearchIn.getStockQuantity(),productSearchIn.getPrice(),productSearchIn.getProductName());
        return page;
    }

    @Override
    public ProductShowOut getById(Integer productId) {
        Product product=productMapper.selectByPrimaryKey(productId);
        ProductDetail productDetail=productDetailMapper.selectByPrimaryKey(productId);
        ProductShowOut p = new ProductShowOut();
        p.setProductId(productId);
        p.setProductCode(product.getProductCode());
        p.setProductName(product.getProductName());
        p.setPrice(product.getPrice());
        p.setDiscount(product.getDiscount());
        p.setStatus(product.getStatus());
        p.setMianPicUrl(product.getMainPicUrl());
        p.setRewordPoints(product.getRewordPoints());
        p.setSortOrder(product.getSortOrder());
        p.setStockQuantity(product.getStockQuantity());
        p.setDescription(productDetail.getDescription());
        String otherPicUrls=productDetail.getOtherPicUrls();
        List<String> otherPic=JSON.parseArray(otherPicUrls,String.class);
        p.setOtherPicUrls(otherPic);
        return p;
    }
}
