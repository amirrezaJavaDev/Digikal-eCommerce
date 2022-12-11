package com.digikalspring.digikalspring.controller;

import com.digikalspring.digikalspring.dto.MessageResponse;
import com.digikalspring.digikalspring.dto.ProductRequestDto;
import com.digikalspring.digikalspring.model.Product;
import com.digikalspring.digikalspring.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProduct(){
        return productService.getAllProduct();
    }
    @PostMapping("/product/save")
    public MessageResponse addProduct(@RequestBody ProductRequestDto requestDto){
        return productService.insertProduct(requestDto);
    }
    @DeleteMapping("/product/delete")
    public MessageResponse deleteProduct(@RequestParam(name = "id") Long id){
        return productService.removeProduct(id);
    }
    @PutMapping("/product/update")
    public MessageResponse updateProduct(@RequestBody ProductRequestDto requestDto, @RequestParam(name = "id")Long id){
        return productService.updateProduct(requestDto,id);
    }
}
