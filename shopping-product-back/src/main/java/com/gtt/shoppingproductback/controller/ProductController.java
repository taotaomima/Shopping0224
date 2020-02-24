package com.gtt.shoppingproductback.controller;

import com.gtt.shoppingproductback.dto.in.ProductIn;
import com.gtt.shoppingproductback.dto.out.ProductOut;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/search")
    public ProductOut search(){
        return null;
    }

    @PostMapping("/create")
    public void addproduct(@RequestBody ProductIn productIn){

    }

    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile mainPicUrl){
        return null;
    }

    @GetMapping("/findbyId")
    public ProductOut findById(@RequestParam Integer productId ){
        return null;
    }

    @PostMapping("/update")
    public void update(@RequestBody ProductIn productIn){

    }

}
