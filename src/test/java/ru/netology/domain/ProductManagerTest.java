package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;
import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Book product1 = new Book (11, "Код", 2000, "Чарльз Петцольд");
    Book product2 = new Book(22, "English is not easy", 1900, "Люси Гутьерес");
    Book product3 = new Book(33, "Над пропастью во ржи", 80, "Джером Дэвид Сэлинджер");

    Smartphone product4 = new Smartphone(44, "iPhone", 7000, "Apple");
    Smartphone product5 = new Smartphone(55, "i70", 88800, "Samsung");
    Smartphone product6 = new Smartphone(66, "RedmiPhone", 33300, "Xiaomi");

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);
    }

    @Test
    public void shouldFindByText() {
        Product[] expected = {product4, product6};
        Product[] actual = manager.searchBy("ho");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllProducts() {
        Product[] expected = {product1, product2, product3, product4, product5, product6};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDeleteProductById() {
        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = repo.removeById(66);
        assertArrayEquals(expected, actual);
    }
}
