package com.sparta.myselectshop.service;

import com.sparta.myselectshop.dto.ProductMypriceRequestDto;
import com.sparta.myselectshop.dto.ProductRequestDto;
import com.sparta.myselectshop.model.Product;
import com.sparta.myselectshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @Transactional
    public Product createProduct(ProductRequestDto requestDto){
        Product product = new Product(requestDto);
        return productRepository.save(product);
    }

    @Transactional
    public Product updateProduct(Long id, ProductMypriceRequestDto requestDto){
        Product product =  productRepository.findById(id).orElseThrow(
                ()-> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        product.updateMyPrice(requestDto.getMyprice());
        return product;
    }

}
