package com.digikalspring.digikalspring.service;

import com.digikalspring.digikalspring.digikalexception.error.ProductDtoException;
import com.digikalspring.digikalspring.dto.MessageResponse;
import com.digikalspring.digikalspring.dto.ProductRequestDto;
import com.digikalspring.digikalspring.model.Product;
import com.digikalspring.digikalspring.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.aspectj.bridge.Message;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

        public List<Product> getAllProduct(){
         List<Product> products = productRepository.findAll();
            return products;
        }

    public MessageResponse insertProduct(ProductRequestDto requestDto) {
            MessageResponse messageResponse = new MessageResponse();
            Product product = new Product(
                    requestDto.getProductName(),
                    requestDto.getCategory(),
                    requestDto.getProductDescription(),
                    requestDto.getProductAvatar(),
                    requestDto.getPrice(),
                    requestDto.getProductCreateAt()
            );
            productRepository.save(product);
             messageResponse.setMessage("Product saved!");
            return messageResponse;
        }
    public MessageResponse removeProduct(Long id) throws ProductDtoException{
                return productRepository.findById(id)
                        .map(product -> {
                            MessageResponse messageResponse = new MessageResponse();
                            productRepository.deleteById(id);
                            messageResponse.setMessage("product deleted with id"+id);
                            return messageResponse;
                        }).orElseThrow(()->new ProductDtoException());
        }
    public MessageResponse updateProduct(ProductRequestDto requestDto,Long id){
          return   productRepository.findById(id)
                    .map(product->{
                        MessageResponse messageResponse = new MessageResponse();
                        product.setProductName(requestDto.getProductName());
                        product.setProductAvatar(requestDto.getProductAvatar());
                        product.setProductDescription(requestDto.getProductDescription());
                        product.setPrice(requestDto.getPrice());
                        product.setCategory(requestDto.getCategory());
                        productRepository.save(product);
                        messageResponse.setMessage("product updated with id"+id);
                        return messageResponse;
                    }).orElseThrow(()->new ProductDtoException());
    }
}
