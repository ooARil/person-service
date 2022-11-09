package liga.medical.personservice.core.utils;

import liga.medical.personservice.core.utils.api.LogHelper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LogHelperImpl implements LogHelper {

    @Override
    public String getId() {
        return UUID.randomUUID().toString();
    }
}
