package com.gtt.shoppingproductback.controller;

import com.github.pagehelper.Page;
import com.gtt.shoppingproductback.dto.in.ProductCreateIn;
import com.gtt.shoppingproductback.dto.in.ProductSearchIn;
import com.gtt.shoppingproductback.dto.in.ProductUpdateIn;
import com.gtt.shoppingproductback.dto.out.PageOut;
import com.gtt.shoppingproductback.dto.out.ProductListOut;
import com.gtt.shoppingproductback.dto.out.ProductShowOut;
import com.gtt.shoppingproductback.es.repo.ProductElasticRepo;
import com.gtt.shoppingproductback.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
    
    @Autowired
    private ProductService productService;


    @GetMapping("/search")
    public PageOut<ProductListOut> search(ProductSearchIn productSearchIn, @RequestParam(required = false,defaultValue = "1") Integer pageNum ){
        Page<ProductListOut> page = productService.search(pageNum,productSearchIn);
        PageOut<ProductListOut> pageOut = new PageOut<>();
        pageOut.setList(page);
        pageOut.setTotal(page.getTotal());
        pageOut.setPageNum(page.getPageNum());
        pageOut.setPageSize(page.getPageSize());
        return pageOut;

    }

    @PostMapping("/create")
    public Integer addproduct(@RequestBody ProductCreateIn productCreateIn){
        Integer productId = productService.create(productCreateIn);
        return productId;
    }

    @GetMapping("/findbyId")
    public ProductShowOut findById(@RequestParam Integer productId ){
        return productService.getById(productId);
    }

    @PostMapping("/update")
    public void update(@RequestBody ProductUpdateIn productUpdateIn){
        productService.update(productUpdateIn);
    }

    @PostMapping("/delete")
    public void deleteProduct(@RequestParam Integer productId){
        productService.delete(productId);
    }

    @PostMapping("/batchDelete")
    public void datchDelete(@RequestParam List<Integer> productIds){
        productService.betchDelete(productIds);
    }
}
