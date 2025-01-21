package valverde.com.mx.literalura.repositories;

import valverde.com.mx.literalura.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

    Book findByTitle(String title);

}
