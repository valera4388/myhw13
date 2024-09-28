package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void RemoveProductExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "ГАЗ", 1_000_000);
        Product product2 = new Product(2, "УАЗ", 1_500_000);
        Product product3 = new Product(3, "ВАЗ", 2_500_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void RemoveProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "ГАЗ", 1_000_000);
        Product product2 = new Product(2, "УАЗ", 1_500_000);
        Product product3 = new Product(3, "ВАЗ", 2_500_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(15);
        });
    }

    @Test
    public void AddProductNotExist() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "ГАЗ", 1_000_000);
        Product product2 = new Product(2, "УАЗ", 1_500_000);
        Product product3 = new Product(3, "ВАЗ", 2_500_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product2, product3};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testHashCode() {
        Product product1 = new Product(1, "ГАЗ", 1_000_000);
        Product product2 = new Product(1, "ГАЗ", 1_000_000);

        Assertions.assertEquals(product1.hashCode(), product2.hashCode());
    }

    @Test
    public void testEquals() {
        Product product1 = new Product(1, "ГАЗ", 1_000_000);
        Product product2 = new Product(2, "УАЗ", 1_500_000);
        Product product3 = new Product(3, "ВАЗ", 2_500_000);

        Assertions.assertTrue(product1.equals(product1));

        Assertions.assertFalse(product3.equals(product2));
        Assertions.assertFalse(product2.equals(product3));

        Assertions.assertFalse(product1.equals(null));

        Assertions.assertFalse(product3.equals("some string"));

    }
}
