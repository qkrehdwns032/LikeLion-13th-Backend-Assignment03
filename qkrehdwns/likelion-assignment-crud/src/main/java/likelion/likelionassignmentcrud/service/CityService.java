package likelion.likelionassignmentcrud.service;

import likelion.likelionassignmentcrud.domain.City;
import likelion.likelionassignmentcrud.domain.Country;
import likelion.likelionassignmentcrud.dto.city.CityResponseDto;
import likelion.likelionassignmentcrud.dto.city.CitySaveDto;
import likelion.likelionassignmentcrud.repository.CityRepository;
import likelion.likelionassignmentcrud.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;

    // 도시 저장
    @Transactional
    public void saveCity(CitySaveDto citySaveDto) {
       Country county = countryRepository.findById(citySaveDto.country_id())
           .orElseThrow(IllegalArgumentException::new);

        City city = City.builder()
            .city_name(citySaveDto.city_name())
            .country(county)
            .build();

        cityRepository.save(city);
    }

    //특정 국가의 도시들 조회
    public List<CityResponseDto> findCitiesByCountryId(Long countryId) {
        Country country = countryRepository.findById(countryId)
            .orElseThrow(IllegalArgumentException::new);

        List<City> cities = cityRepository.findByCountry(country);

        return cities.stream()
            .map(CityResponseDto::from)
            .toList();
    }

}
