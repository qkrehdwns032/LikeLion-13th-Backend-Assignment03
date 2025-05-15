package likelion.likelionassignmentcrud.controller;

import likelion.likelionassignmentcrud.domain.City;
import likelion.likelionassignmentcrud.dto.city.CityResponseDto;
import likelion.likelionassignmentcrud.dto.city.CitySaveDto;
import likelion.likelionassignmentcrud.service.CityService;
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
public class CityController {

    private final CityService cityService;

    // 도시 저장
    @PostMapping("/city/save")
    public ResponseEntity<String> saveCity(@RequestBody CitySaveDto citySaveDto) {
        cityService.saveCity(citySaveDto);
        return new ResponseEntity<>("도시 저장!", HttpStatus.CREATED);
    }

    // 특정 국가의 도시들 조회
    @GetMapping("/city/{countryId}")
    public ResponseEntity<List<CityResponseDto>> findCitiesByCountryId(@PathVariable Long countryId) {

        return new ResponseEntity<>(cityService.findCitiesByCountryId(countryId), HttpStatus.OK);
    }

}
