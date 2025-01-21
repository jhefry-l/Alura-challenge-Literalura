package valverde.com.mx.literalura.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "languages")
@Data
public class LanguageT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private Integer languageId;

    @Column(name = "language_code")
    private String code;

    @Column(name = "display_name")
    private String name;

    @ManyToMany(mappedBy = "languages")
    private List<Book> books;

}
