package valverde.com.mx.literalura.services;

import lombok.AllArgsConstructor;
import valverde.com.mx.literalura.models.Author;
import valverde.com.mx.literalura.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> getAuthorsAliveInYear(int year) {
        return authorRepository.findAliveAuthorsInYear(year);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public List<Author> getAuthorsByBirthYear(int birthYear) {
        return authorRepository.findByBirthYear(birthYear);
    }

    @Override
    public List<Author> getAuthorsByDeathYear(int deathYear) {
        return authorRepository.findByDeathYear(deathYear);
    }

    @Override
    public List<Author> getAuthorsByName(String name) {
        return authorRepository.findByName(name);
    }

    @Override
    public void saveAuthor(Author author) {
        authorRepository.save(author);
    }

}
