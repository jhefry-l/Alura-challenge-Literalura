package valverde.com.mx.literalura.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "books")
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer bookId;

    @Column(nullable = false, length = 100)
    private String title;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_language",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private List<LanguageT> languages;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_format",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "format_id")
    )
    private List<Format> formats;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_translator",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "translator_id")
    )
    private List<Translator> translators;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_bookshelf",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "bookshelf_id")
    )
    private List<Bookshelf> bookshelves;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_subject",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subjects> subjects;

    @Column(nullable = false)
    private Boolean copyright;

    @Column(name = "media_type")
    private String mediaType;

    @Column(name = "download_count")
    private Integer downloadCount;

}
