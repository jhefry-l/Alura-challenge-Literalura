package valverde.com.mx.literalura.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "formats")
@Data
public class Format {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "format_id")
    private Integer formatId;

    @Column(name = "format_type")
    private String mimeType;

    @Column
    private String url;

    @ManyToMany(mappedBy = "formats")
    private List<Book> books;

}
