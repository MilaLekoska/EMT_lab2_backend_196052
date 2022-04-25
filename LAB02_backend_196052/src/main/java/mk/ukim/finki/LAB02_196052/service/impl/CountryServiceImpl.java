package mk.ukim.finki.LAB02_196052.service.impl;

import mk.ukim.finki.LAB02_196052.model.Country;
import mk.ukim.finki.LAB02_196052.model.exceptions.CountryNotFoundException;
import mk.ukim.finki.LAB02_196052.repository.CountryRepository;
import mk.ukim.finki.LAB02_196052.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> listCountries() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        Country country = this.countryRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundException(id));

        return Optional.of(country);
    }

    @Override
    public List<Country> findAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Optional<Country> save(Country country) {
        return Optional.of(this.countryRepository.save(country));
    }
}
