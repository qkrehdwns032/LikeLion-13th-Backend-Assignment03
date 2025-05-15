package likelion.likelionassignmentcrud.repository;

import likelion.likelionassignmentcrud.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
