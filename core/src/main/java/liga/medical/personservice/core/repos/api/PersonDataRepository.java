package liga.medical.personservice.core.repos.api;

import liga.medical.personservice.core.model.PersonData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonDataRepository extends JpaRepository<PersonData, Long> {

}
