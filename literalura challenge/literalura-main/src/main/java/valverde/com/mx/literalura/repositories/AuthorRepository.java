package valverde.com.mx.literalura.repositories;

import valverde.com.mx.literalura.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    List<Author> findByBirthYear(Integer year);

    List<Author> findByDeathYear(Integer deathYear);

    List<Author> findByName(String name);

    @Query("SELECT a FROM Author a WHERE a.birthYear <= :year AND (a.deathYear > :year OR a.deathYear IS NULL)")
    List<Author> findAliveAuthorsInYear(@Param("year") int year);

}
