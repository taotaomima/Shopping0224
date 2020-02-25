package com.gtt.shoppingstoreback.controller;

import com.gtt.shoppingstoreback.dto.in.ProductSearchIn;
import com.gtt.shoppingstoreback.dto.out.PageOut;
import com.gtt.shoppingstoreback.dto.out.ProductListOut;
import com.gtt.shoppingstoreback.dto.out.ProductShowOut;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/search")
    public PageOut<ProductListOut> search(@RequestBody ProductSearchIn productSearchIn, @RequestParam Integer pageNum){return null;}


    @GetMapping("/getById")
    public ProductShowOut getById(@RequestParam Integer productId){return null;}
}
