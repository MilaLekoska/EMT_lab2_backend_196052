package mk.ukim.finki.LAB02_196052.service;

import mk.ukim.finki.LAB02_196052.model.Book;
import mk.ukim.finki.LAB02_196052.model.dto.BookDto;
import mk.ukim.finki.LAB02_196052.model.enumerations.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> save(String name, Category category, Long authorId, Integer availableCopies);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> save(Book book);

    Optional<Book> edit(Long id, String name, Category category, Long authorId, Integer availableCopies);

    Optional<Book> edit(Long id, BookDto bookDto);

    void deleteById(Long id);

    Optional<Book> markAsTaken(Long id);
}
