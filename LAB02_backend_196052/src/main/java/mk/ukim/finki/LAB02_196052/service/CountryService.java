package mk.ukim.finki.LAB02_196052.service;

import mk.ukim.finki.LAB02_196052.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> findAll();

    List<Country> listCountries();

    Optional<Country> findById(Long id);

    Optional<Country> save(Country country);

}

