package repositories;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import models.Product;

public class ProductRepository {
    List<Product> data;

    public ProductRepository(List<Product> data) {
        this.data = Arrays.asList(
            new Product(1L, "DellXPS", 2000L),
            new Product(2L, "Asus Zephyrus", 2500L),
            new Product(3L, "Alienware M17", 2300L),
            new Product(4L, "Razer", 3200L)
        );
    }

    public List<Product> findAll(){
        return data;
    }

}
