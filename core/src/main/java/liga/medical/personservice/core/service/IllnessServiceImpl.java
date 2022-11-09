package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.Illness;
import liga.medical.personservice.core.repos.api.IllnessRepository;
import liga.medical.personservice.core.service.api.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IllnessServiceImpl implements IllnessService {

    @Autowired
    IllnessRepository illnessRepository;

    @Override
    public Illness save(Illness entity) {
        return illnessRepository.save(entity);
    }

    @Override
    public Illness findById(Long id) {
        return illnessRepository.findById(id).get();
    }

    @Override
    public List<Illness> findAll() {
        return illnessRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        illnessRepository.deleteById(id);
    }
}
