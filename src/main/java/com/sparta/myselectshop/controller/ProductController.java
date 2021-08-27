package com.sparta.myselectshop.controller;

import com.sparta.myselectshop.dto.ProductMypriceRequestDto;
import com.sparta.myselectshop.dto.ProductRequestDto;
import com.sparta.myselectshop.model.Product;
import com.sparta.myselectshop.repository.ProductRepository;
import com.sparta.myselectshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;

    // 관심 상품 등록
    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto requestDto){
        return productService.createProduct(requestDto);
    }

    // 관심 상품 조회
    @GetMapping("/api/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    // 관심 상품 최저가 등록
    @PutMapping("/api/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto){
        Product product = productService.updateProduct(id,requestDto);
        return product.getId();
    }
}
