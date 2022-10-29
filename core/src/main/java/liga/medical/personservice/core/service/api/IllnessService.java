package liga.medical.personservice.core.service.api;

import liga.medical.personservice.core.model.entity.Illness;

import java.util.List;

public interface IllnessService {

    Illness save(Illness entity);

    Illness findById(Long id);

    List<Illness> findAll();

    void deleteById(Long id);
}
