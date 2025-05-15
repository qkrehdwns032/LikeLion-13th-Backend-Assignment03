package likelion.likelionassignmentcrud.dto.country;

import likelion.likelionassignmentcrud.domain.Country;

public record CountryResponseDto(
    Long id,
    String country_name
) {
    public static CountryResponseDto from(Country country){
        return new CountryResponseDto(country.getId(), country.getCountry_name());
    }
}
