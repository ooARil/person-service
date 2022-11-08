package liga.medical.personservice.core.security.service.api;

import org.springframework.security.core.Authentication;

public interface AuthLogService {

    void authLog(Authentication authentication);
}
