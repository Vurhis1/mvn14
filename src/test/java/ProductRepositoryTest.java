import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.gavaqa.Book;
import ru.netology.gavaqa.Product;
import ru.netology.repository.NotFoundException;
import ru.netology.repository.ProductRepository;

public class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();

    Book book1 = new Book(432, "Гарри Поттер", 900, "Джоан Роулинг");
    Book book2 = new Book(321, "Властелин колец", 1200, "Дж.Р.Р.Толкиен");
    Book book3 = new Book(210, "Портрет Дориана Грея", 550, "Оскар Уайльд");

    @Test
    public void saveItemsInRepository() {

        repo.save(book1);
        repo.save(book2);
        repo.save(book3);

        Product[] expected = {book1, book2, book3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeBook() {

        repo.save(book1);
        repo.save(book2);
        repo.save(book3);
        repo.removeById(book3.getId());

        Product[] expected = {book1, book2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeNotExistingId() {

        repo.save(book1);
        repo.save(book2);
        repo.save(book3);

        Assertions.assertThrows(RuntimeException.class, () -> {
            repo.removeById(909);
        });
    }
}