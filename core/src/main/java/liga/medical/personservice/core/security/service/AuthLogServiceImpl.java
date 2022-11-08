package liga.medical.personservice.core.security.service;

import liga.medical.personservice.core.security.entity.AuthLog;
import liga.medical.personservice.core.security.repository.AuthLogRepository;
import liga.medical.personservice.core.security.service.api.AuthLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@RequiredArgsConstructor
@Service
public class AuthLogServiceImpl implements AuthLogService {

    private final AuthLogRepository authLogRepository;

    @Override
    public void authLog(Authentication authentication) {
        AuthLog logEntity = new AuthLog();
        logEntity.setUsername(authentication.getName());
        logEntity.setDttm(new Timestamp(System.currentTimeMillis()));
        logEntity.setSuccess(authentication.isAuthenticated());

        authLogRepository.save(logEntity);
    }
}