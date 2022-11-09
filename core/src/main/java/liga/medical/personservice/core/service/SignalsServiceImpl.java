package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.PersonData;
import liga.medical.personservice.core.model.Signals;
import liga.medical.personservice.core.repos.api.PersonDataRepository;
import liga.medical.personservice.core.repos.api.SignalsRepository;
import liga.medical.personservice.core.service.api.SignalsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SignalsServiceImpl implements SignalsService {

    private final SignalsRepository signalsRepository;
    private final PersonDataRepository personDataRepository;

    @Override
    public Signals save(Signals signals) {
        Optional<PersonData> optional = personDataRepository.findById(signals.getPersonDataId());
        if (optional.isPresent()) {
            return signalsRepository.save(signals);
        } else {
            return null;
        }
    }
}
