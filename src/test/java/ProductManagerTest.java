import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(1, "Евгений Онегин", 300, "А.С.Пушкин");
    Product product2 = new Book(222, "Преступление и наказание", 350, "Ф.М. Достоевский");
    Product product3 = new Book(42, "Алхимик", 350, "П.Коэльо");
    Product product4 = new Book(58, "Алхимик", 350, "Г.Ф. Лавкрафт");
    Product product5 = new Smartphone(15, "Iphone 12", 50_000, "Apple");
    Product product6 = new Smartphone(333, "Xiaomi Redmi 10", 27_000, "Xiaomi");


    @Test
    public void shouldSearchByName() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);

        Product[] expected = {product1};
        Product[] actual = manager.searchBy("Евгений Онегин");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByName_2() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);

        Product[] expected = {product6};
        Product[] actual = manager.searchBy("Xiaomi Redmi 10");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchByNameThatDoesNotExist() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Анна Каренина");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotSearchIfNoProductsAdded() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("Iphone 12");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchIfOneProductAdded() {
        manager.add(product2);

        Product[] expected = {product2};
        Product[] actual = manager.searchBy("Преступление и наказание");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMoreThanOneProduct() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);

        Product[] expected = {product3, product4};
        Product[] actual = manager.searchBy("Алхимик");

        Assertions.assertArrayEquals(expected, actual);
    }
}
