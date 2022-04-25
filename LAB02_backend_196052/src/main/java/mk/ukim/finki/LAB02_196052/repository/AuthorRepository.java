package mk.ukim.finki.LAB02_196052.repository;

import mk.ukim.finki.LAB02_196052.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
