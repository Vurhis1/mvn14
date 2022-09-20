package ru.netology.repository;

import ru.netology.gavaqa.Product;

public class ProductManager {

    protected ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public Product[] add(Product product) {
        repo.save(product);
        return new Product[]{product};
    }


    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repo.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }


    public boolean matches(Product product, String search) {
        if (product.getTitle().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}