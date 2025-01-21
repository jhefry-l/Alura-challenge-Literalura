package valverde.com.mx.literalura.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "translators")
@Data
public class Translator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "translator_id")
    private Integer translatorId;

    @Column(nullable = false)
    private String name;

    @Column(name = "birth_year")
    private Integer birthYear;

    @Column(name = "death_year")
    private Integer deathYear;

    @ManyToMany(mappedBy = "translators")
    private List<Book> books;

}
