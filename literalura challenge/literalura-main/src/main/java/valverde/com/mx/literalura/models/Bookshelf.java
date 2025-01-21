package valverde.com.mx.literalura.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "bookshelves")
@Data
public class Bookshelf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookshelf_id")
    private Integer bookshelfId;

    @Column(length = 2000)
    private String bookshelf;

    @ManyToMany(mappedBy = "bookshelves")
    private List<Book> books;

}
