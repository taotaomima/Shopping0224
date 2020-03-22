package com.gtt.shoppingstoreback.controller;

import com.github.pagehelper.Page;
import com.gtt.shoppingstoreback.dto.in.ProductSearchIn;
import com.gtt.shoppingstoreback.dto.out.PageOut;
import com.gtt.shoppingstoreback.dto.out.ProductListOut;
import com.gtt.shoppingstoreback.dto.out.ProductShowOut;
import com.gtt.shoppingstoreback.po.Product;
import com.gtt.shoppingstoreback.servie.ProductOperationService;
import com.gtt.shoppingstoreback.servie.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
    @Resource
    private ProductService productService;
    @Resource
    private ProductOperationService productOperationService;

    @GetMapping("/search")
    public PageOut<ProductListOut> search(@RequestBody ProductSearchIn productSearchIn, @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        Page<ProductListOut> page = productService.search(pageNum);
        PageOut<ProductListOut> pageOut = new PageOut<>();
        pageOut.setPageNum(page.getPageNum());
        pageOut.setPageSize(page.getPageSize());
        pageOut.setTotal(page.getTotal());
        pageOut.setList(page);
        return pageOut;
    }


    @GetMapping("/getById")
    public ProductShowOut getById(@RequestParam Integer productId){
        ProductShowOut productShowOut = productService.getById(productId);
        productOperationService.count(productId);
        return productShowOut;

    }
}
