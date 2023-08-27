package com.example.teste.controllers;

import com.example.teste.dto.ProductDTO;
import com.example.teste.entity.Product;
import com.example.teste.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.modelmapper.ModelMapper;

import java.util.List;

@RestController
@RequestMapping(value = "product")
@CrossOrigin("http://localhost:8081/")
public class ProductController {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductService service;


    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = service.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody ProductDTO productDTO) {
        Product product = convertToEntity(productDTO);
        return new ResponseEntity<>(service.saveProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteProduct(@PathVariable(value="id") Integer id) {
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> editProduct(
            @PathVariable(value = "id") Integer id,
            @RequestBody ProductDTO productDTO) {

        Product updatedProduct = convertToEntity(productDTO);
        Product editedProduct = service.updateProduct(id, updatedProduct);

        return ResponseEntity.ok(editedProduct);
    }

    private Product convertToEntity(ProductDTO productDTO) {
        return modelMapper.map(productDTO, Product.class);
    }

}