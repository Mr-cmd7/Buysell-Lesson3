package com.example.buysell.controllers;

import com.example.buysell.models.Product;
import com.example.buysell.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.util.List;

@RestController
@RequiredArgsConstructor

public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public List<Product> products() {
        return productService.listProducts();
    }

    @GetMapping("/product/{id}")
    public Product productInfo(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping("/product/create")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @DeleteMapping("/product/delete/{id}")
    public Product deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
    @PutMapping("/product/update/{id}")
    public Product updateProduct(@RequestBody Product product,@PathVariable Long id)
    {
        return productService.updateProductById(product,id);
    }
}
