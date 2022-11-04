package liga.medical.personservice.core.security.repository;

import liga.medical.personservice.core.security.entity.AuthLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthLogRepository extends JpaRepository<AuthLog, Long> {

}
