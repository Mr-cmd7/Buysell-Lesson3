package com.example.buysell.services;

import com.example.buysell.models.Product;
import com.example.buysell.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    public Product deleteProduct(Long id) {
        Product product=productRepository.findById(id).orElse(null);
        if(product!=null) {
            productRepository.deleteById(id);
            return product;
        }
        else
            return null;
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
    public Product updateProductById(Product productData, Long id){
        Product product=productRepository.findById(id).orElse(null);
        if(product!=null) {
            product.setCity(productData.getCity());
            product.setDescription(productData.getDescription());
            product.setTitle(productData.getTitle());
            product.setPrice(productData.getPrice());
            product.setAuthor(productData.getAuthor());
            productRepository.save(product);
            return product;
        }
        else
            return null;
    }
}
