package valverde.com.mx.literalura.services;

import valverde.com.mx.literalura.models.Book;

import java.util.List;

public interface BookService {

    String findAllBooks() throws Exception;

    Book findBookByTitle(String title);

    String findBooksByLanguages(String languages) throws Exception;

    void saveBook(Book book);

    List<Book> findTop10MostDownloadedBooks();

}
