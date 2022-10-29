package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.entity.MedicalCard;
import liga.medical.personservice.core.repos.api.MedicalCardRepository;
import liga.medical.personservice.core.service.api.MedicalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalCardServiceImpl implements MedicalCardService {

    @Autowired
    MedicalCardRepository medicalCardRepository;

    @Override
    public MedicalCard save(MedicalCard entity) {
        return medicalCardRepository.save(entity);
    }

    @Override
    public MedicalCard findById(Long id) {
        return medicalCardRepository.findById(id).get();
    }

    @Override
    public List<MedicalCard> findAll() {
        return medicalCardRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        medicalCardRepository.deleteById(id);
    }
}
