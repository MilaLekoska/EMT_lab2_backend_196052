package mk.ukim.finki.LAB02_196052.service.impl;

import mk.ukim.finki.LAB02_196052.model.Author;
import mk.ukim.finki.LAB02_196052.model.Country;
import mk.ukim.finki.LAB02_196052.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.LAB02_196052.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.LAB02_196052.repository.AuthorRepository;
import mk.ukim.finki.LAB02_196052.repository.CountryRepository;
import mk.ukim.finki.LAB02_196052.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Optional<Author> save(String name, String surname, Long countryId) {
        Country country = this.countryRepository.findById(countryId)
                .orElseThrow(() -> new CountryNotFoundException(countryId));

        Author author = new Author(name, surname, country);

        return Optional.of(this.authorRepository.save(author));
    }

    @Override
    public Optional<Author> save(Author author) {
        return Optional.of(this.authorRepository.save(author));
    }

    @Override
    public Optional<Author> edit(Long id, String name, String surname, Long countryId) {
        Author author = this.authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));
        Country country = this.countryRepository.findById(countryId)
                .orElseThrow(() -> new CountryNotFoundException(countryId));

        author.setName(name);
        author.setSurname(surname);
        author.setCountry(country);
        return Optional.of(this.authorRepository.save(author));
    }

    @Override
    public void deleteById(Long id) {
        this.authorRepository.findById(id);
    }
}