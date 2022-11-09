package liga.medical.personservice.core.repos.api;

import liga.medical.personservice.core.model.Illness;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IllnessRepository extends JpaRepository<Illness, Long> {
}
