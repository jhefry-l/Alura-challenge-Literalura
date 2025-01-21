package valverde.com.mx.literalura.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "authors")
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Integer authorId;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(name = "birth_year", nullable = false)
    private Integer birthYear;

    @Column(name = "death_year")
    private Integer deathYear;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;


}
