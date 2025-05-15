package likelion.likelionassignmentcrud.repository;

import likelion.likelionassignmentcrud.domain.City;
import likelion.likelionassignmentcrud.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findByCountry(Country country);
}
