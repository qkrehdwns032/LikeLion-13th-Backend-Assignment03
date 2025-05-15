package likelion.likelionassignmentcrud.controller;

import likelion.likelionassignmentcrud.domain.Country;
import likelion.likelionassignmentcrud.dto.country.CountryResponseDto;
import likelion.likelionassignmentcrud.dto.country.CountrySaveDto;
import likelion.likelionassignmentcrud.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CountryController {

    private final CountryService countryService;

    @PostMapping("/country/save")
    public ResponseEntity<String> saveCountry(@RequestBody CountrySaveDto countrySaveDto) {

        countryService.saveCountry(countrySaveDto);

        return new ResponseEntity<>("사용자 저장!", HttpStatus.CREATED);
    }

    @GetMapping("/country/all")
    public ResponseEntity<List<CountryResponseDto>> findAllCountries() {
        return new ResponseEntity<>(countryService.findAllCountries(), HttpStatus.OK);
    }

    @GetMapping("/country/{countryId}")
    public ResponseEntity<CountryResponseDto> findCountryById(@PathVariable Long countryId) {
        return new ResponseEntity<>(countryService.findCountryById(countryId), HttpStatus.OK);
    }

}
