package likelion.likelionassignmentcrud.service;

import likelion.likelionassignmentcrud.domain.Country;
import likelion.likelionassignmentcrud.dto.country.CountryResponseDto;
import likelion.likelionassignmentcrud.dto.country.CountrySaveDto;
import likelion.likelionassignmentcrud.repository.CityRepository;
import likelion.likelionassignmentcrud.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;

    // 국가 저장
    @Transactional
    public void saveCountry(CountrySaveDto countrySaveDto) {
        Country country = Country.builder()
            .country_name(countrySaveDto.country_name())
            .build();

        countryRepository.save(country);
    }


    //모든 국가 조회
    public List<CountryResponseDto> findAllCountries() {
        List<Country> cities = countryRepository.findAll();

        return cities.stream()
            .map(CountryResponseDto::from)
            .toList();
    }

    //단일 국가 조회
    public CountryResponseDto findCountryById(Long countryId) {
        Country country = countryRepository
            .findById(countryId)
            .orElseThrow(() -> new IllegalArgumentException("해당 국가를 찾을 수 없습니다."));

        return CountryResponseDto.from(country);
    }

}
