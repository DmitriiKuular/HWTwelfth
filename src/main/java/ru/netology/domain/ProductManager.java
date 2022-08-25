package ru.netology.domain;

import ru.netology.repository.ProductRepository;

import java.util.Arrays;

public class ProductManager {
    private ProductRepository repo;
    
    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.save(product);
    }


    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.findAll()) {
            if (product.matches(text)) {
            Product[] tmp = Arrays.copyOf(result, result.length + 1);
            tmp[tmp.length - 1] = product;
            result = tmp;
            }
        }
        return result;
    }
}
