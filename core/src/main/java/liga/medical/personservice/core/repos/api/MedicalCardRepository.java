package liga.medical.personservice.core.repos.api;

import liga.medical.personservice.core.model.MedicalCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalCardRepository extends JpaRepository<MedicalCard, Long> {
}
