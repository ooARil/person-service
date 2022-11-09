package liga.medical.personservice.core.service.api;

import liga.medical.personservice.core.model.MedicalCard;

import java.util.List;

public interface MedicalCardService {

    MedicalCard save(MedicalCard entity);

    MedicalCard findById(Long id);

    List<MedicalCard> findAll();

    void deleteById(Long id);
}
