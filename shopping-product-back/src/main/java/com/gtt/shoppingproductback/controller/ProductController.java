package com.gtt.shoppingproductback.controller;

import com.gtt.shoppingproductback.dto.in.ProductCreateIn;
import com.gtt.shoppingproductback.dto.in.ProductUpdateIn;
import com.gtt.shoppingproductback.dto.in.productListIn;
import com.gtt.shoppingproductback.dto.out.ProductShowOut;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/search")
    public ProductShowOut search(productListIn productListIn, @RequestParam Integer pageNum ){
        return null;
    }

    @PostMapping("/create")
    public Integer addproduct(@RequestBody ProductCreateIn productCreateIn){return null; }

    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile mainPicUrl){
        return null;
    }

    @GetMapping("/findbyId")
    public ProductShowOut findById(@RequestParam Integer productId ){
        return null;
    }

    @PostMapping("/update")
    public void update(@RequestBody ProductUpdateIn productUpdateIn){

    }

    @PostMapping("/delete")
    public void deleteProduct(@RequestParam Integer productId){}
}
