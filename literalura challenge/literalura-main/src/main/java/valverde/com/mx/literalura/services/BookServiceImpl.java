package valverde.com.mx.literalura.services;

import lombok.AllArgsConstructor;
import valverde.com.mx.literalura.models.Book;
import valverde.com.mx.literalura.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public String findAllBooks() throws Exception {

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://gutendex.com/books"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new RuntimeException("Error al obtener los libros: " + response.statusCode());
        }
    }

    public Book findBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public String findBooksByLanguages(String languages) throws Exception {

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(10))
                .followRedirects(HttpClient.Redirect.NORMAL)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://gutendex.com/books?languages=" + languages))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 200) {
            return response.body();
        } else {
            throw new RuntimeException("Error al obtener los libros: " + response.statusCode());
        }
    }

    public void saveBook(Book book){
        bookRepository.save(book);
    }

    @Override
    public List<Book> findTop10MostDownloadedBooks() {
        return bookRepository.findAll()
                .stream()
                .sorted(Comparator.comparingInt(Book::getDownloadCount).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }

}
