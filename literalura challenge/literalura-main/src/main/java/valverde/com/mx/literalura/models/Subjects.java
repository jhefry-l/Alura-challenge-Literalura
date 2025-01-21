package valverde.com.mx.literalura.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class Subjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Integer subjectId;

    @Column(nullable = false)
    private String subject;

    @ManyToMany(mappedBy = "subjects")
    private List<Book> books;

}
