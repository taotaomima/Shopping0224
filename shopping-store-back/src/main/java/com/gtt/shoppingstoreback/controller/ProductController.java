package com.gtt.shoppingstoreback.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.gtt.shoppingstoreback.dto.in.ProductSearchIn;
import com.gtt.shoppingstoreback.dto.out.PageOut;
import com.gtt.shoppingstoreback.dto.out.ProductListOut;
import com.gtt.shoppingstoreback.dto.out.ProductShowOut;
import com.gtt.shoppingstoreback.mq.HotProductDto;
import com.gtt.shoppingstoreback.po.Product;
import com.gtt.shoppingstoreback.po.ProductOperation;
import com.gtt.shoppingstoreback.servie.ProductOperationService;
import com.gtt.shoppingstoreback.servie.ProductService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {
    @Resource
    private ProductService productService;
    @Resource
    private ProductOperationService productOperationService;
    @Resource
    private KafkaTemplate kafkaTemplate;

    @Resource
    private RedisTemplate<String,String> redisTemplate;


    @GetMapping("/search")
    public PageOut<ProductListOut> search(@RequestBody ProductSearchIn productSearchIn, @RequestParam(required = false,defaultValue = "1") Integer pageNum){
        Page<ProductListOut> page = productService.search(productSearchIn,pageNum);
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
        /*productOperationService.count(productId);*/
       /* HotProductDto hotProductDto = new HotProductDto();
        hotProductDto.setProductId(productId);
        hotProductDto.setProductCode(productShowOut.getProductCode());*/
        // 发送消息到kafka
        kafkaTemplate.send("hotproduct",productId.toString());
        return productShowOut;

    }

    @GetMapping("/hot")
    //@Cacheable("hotproduct")
    public List<ProductOperation> getHot(){
        /*List<ProductOperation> productOperations = productOperationService.selectHotProduct();
        return productOperations;*/

        String hotproduct = redisTemplate.opsForValue().get("hotproduct");
        if(hotproduct !=null){
            List<ProductOperation> productOperations = JSON.parseArray(hotproduct, ProductOperation.class);
            return productOperations;
        }else{
            List<ProductOperation> product = productOperationService.selectHotProduct();
            redisTemplate.opsForValue().set("hotproduct",JSON.toJSONString(product));
            return product;
        }
    }
}
