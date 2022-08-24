package ru.netology.repository;

import ru.netology.domain.Product;
import ru.netology.exceptions.AlreadyExistsException;
import ru.netology.exceptions.NotFoundException;

public class ProductRepository {
    Product[] products = new Product[0];

    public void save(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
            if (tmp[i].getId() == product.getId()) {
                throw new AlreadyExistsException("Товар с таким Id: " + product.getId() + " уже существует");
            }
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public Product[] removeById(int id) {
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;

        if (findById(id) == null) {
            throw new NotFoundException("Товар с таким Id: " + id + " не найден");
        }

        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
        return products;
    }
}
