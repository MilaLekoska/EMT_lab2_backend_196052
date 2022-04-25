package mk.ukim.finki.LAB02_196052.model.config;

import mk.ukim.finki.LAB02_196052.model.Author;
import mk.ukim.finki.LAB02_196052.model.Book;
import mk.ukim.finki.LAB02_196052.model.Country;
import mk.ukim.finki.LAB02_196052.service.AuthorService;
import mk.ukim.finki.LAB02_196052.service.BookService;
import mk.ukim.finki.LAB02_196052.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import static mk.ukim.finki.LAB02_196052.model.enumerations.Category.*;

@Component
public class DataInitializer {

    private final CountryService countryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public DataInitializer(CountryService countryService, AuthorService authorService, BookService bookService) {
        this.countryService = countryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @PostConstruct
    public void init(){
        Country country1 = new Country("Italy", "Europa");
        Country country2 = new Country( "Grate Britain", "Europa");
        Country country3 = new Country( "Macedonia", "Europa");
        Country country4 = new Country( "France", "Europa");

        this.countryService.save(country1);
        this.countryService.save(country2);
        this.countryService.save(country3);
        this.countryService.save(country4);

        Author author1 = new Author("Dante", "Alighieri", country1);
        Author author2 = new Author("Charles", "Dickens", country2);
        Author author3 = new Author("Petre M.", "Andreevski", country3);
        Author author4 = new Author("Albert", "Camus", country4);

        this.authorService.save(author1);
        this.authorService.save(author2);
        this.authorService.save(author3);
        this.authorService.save(author4);

        Book book1 = new Book("Divine Comedy", CLASSICS, author1, 5);
        Book book2 = new Book("Oliver Twist", CLASSICS, author2, 3);
        Book book3 = new Book("Pirej", HISTORY, author3, 9);
        Book book4 = new Book("The Stranger", NOVEL, author4, 4);

        this.bookService.save(book1);
        this.bookService.save(book2);
        this.bookService.save(book3);
        this.bookService.save(book4);
    }
}
