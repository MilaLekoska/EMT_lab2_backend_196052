package mk.ukim.finki.LAB02_196052.service;

import mk.ukim.finki.LAB02_196052.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    Optional<Author> findById(Long id);

    List<Author> findAll();

    Optional<Author> save(String name, String surname, Long countryId);

    Optional<Author> save(Author author);

    Optional<Author> edit(Long id, String name, String surname, Long countryId);

    void deleteById(Long id);
}