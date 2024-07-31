package com.example.first_app.service;

import com.example.first_app.model.Product;
import com.example.first_app.repository.ProductRepo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import java.util.List;

@Getter
@Service

public class ProductService {

    @Autowired
    ProductRepo repo;


    public List<Product> getProducts() {
        return repo.findAll();
    }

    public Product getProductByID(int prodId) {
        return repo.findById(prodId).orElse(new Product());
    }

    public void addProduct(Product prod) {
        repo.save(prod);
    }

    public void updateProduct(Product prod) {
        repo.save(prod);
    }

    public void deleteProduct(int prodId) {

        repo.deleteById(prodId);
    }
}
