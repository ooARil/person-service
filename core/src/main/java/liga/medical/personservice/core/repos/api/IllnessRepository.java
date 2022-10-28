package liga.medical.personservice.core.repos.api;

import liga.medical.personservice.core.model.entity.Illness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IllnessRepository extends JpaRepository<Illness, Long> {
}
