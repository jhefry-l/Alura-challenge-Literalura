package valverde.com.mx.literalura.services;

import valverde.com.mx.literalura.models.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAuthorsByName(String name);

    List<Author> getAuthorsAliveInYear(int year);

    List<Author> getAllAuthors();

    List<Author> getAuthorsByBirthYear(int birthYear);

    List<Author> getAuthorsByDeathYear(int deathYear);

    void saveAuthor(Author author);

}
