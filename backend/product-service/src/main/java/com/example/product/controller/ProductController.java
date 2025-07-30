package com.example.product.controller;

import com.example.product.entity.Product;
import com.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) { return ResponseEntity.ok(productService.addProduct(product)); }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() { return ResponseEntity.ok(productService.getAllProducts()); }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) { return ResponseEntity.ok(productService.getProductById(id)); }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) { productService.deleteProduct(id); return ResponseEntity.ok("Product deleted successfully"); }
}
