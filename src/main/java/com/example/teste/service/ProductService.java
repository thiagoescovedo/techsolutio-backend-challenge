package com.example.teste.service;

import com.example.teste.dao.ProductRepository;
import com.example.teste.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
       return repository.save(product);
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product obtainProductById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public void deleteProduct(Integer id) {
        Product productToDelete = obtainProductById(id);
        repository.delete(productToDelete);
    }

    public Product updateProduct(Integer id, Product updatedProduct) {
        Product existingProduct = obtainProductById(id);

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setSupplier(updatedProduct.getSupplier());
        existingProduct.setPrice(updatedProduct.getPrice());

        return repository.save(existingProduct);
    }
}


