import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.gavaqa.Book;
import ru.netology.gavaqa.Product;
import ru.netology.gavaqa.Smartphone;
import ru.netology.repository.ProductManager;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Book book1 = new Book(432, "Гарри Поттер", 900, "Джоан Роулинг");
    Book book2 = new Book(321, "Властелин колец", 1200, "Дж.Р.Р.Толкиен");
    Book book3 = new Book(210, "Портрет Дориана Грея", 550, "Оскар Уайльд");
    Smartphone smartphone1 = new Smartphone(987, "IPhone", 100_000, "Apple");
    Smartphone smartphone2 = new Smartphone(876, "Galaxy s20", 90_000, "Samsung");
    Smartphone smartphone3 = new Smartphone(765, "Note 10", 20_000, "Xiaomi");

    @BeforeEach
    public void setup() {

        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);
    }

    @Test
    public void TestSearchBook() {

        Product[] actual = manager.searchBy("Портрет");
        Product[] expected = {book3};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void TestSearchSmartphone() {

        Product[] actual = manager.searchBy("Galaxy s20");
        Product[] expected = {smartphone2};

        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    public void renameSmartphone() {
        smartphone1.setManufacturer("Huawei");

        String actual = ("Huawei");
        String expected = smartphone1.getManufacturer();

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void renameBook() {
        book1.setAuthor();

        String actual = ("Джоан Роулинг");
        String expected = book1.getAuthor();

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void renameTitle() {
        book2.setTitle("Гарри Поттер");

        String actual = ("Гарри Поттер");
        String expected = book2.getTitle();

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void changePrice() {
        book3.setPrice(100_000);

        int actual = 100_000;
        int expected = book3.getPrice();

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void changeId() {
        book3.setId(323);

        int actual = 323;
        int expected = book3.getId();

        Assertions.assertEquals(actual, expected);
    }
    @Test
    public void addBook() {
        Book book4 = new Book (999, "Мастер и Маргарита", 666, "Михаил Булгаков");
        repo.save(book4);
        manager.add(book4);

        Product[] actual = manager.add(book4);
        Product[] expected = {book4};

        Assertions.assertArrayEquals(actual, expected);
    }
    @Test
    public void searchAllBooks() {
        Product[] actual = manager.searchBy("а");
        Product[] expected = {book1,book2,book3};

        Assertions.assertArrayEquals(actual, expected);

    }
}


