package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.PersonData;
import liga.medical.personservice.core.repos.api.PersonDataRepository;
import liga.medical.personservice.core.service.api.PersonDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonDataServiceImpl implements PersonDataService {

    @Autowired
    PersonDataRepository personDataRepository;

    @Override
    public PersonData save(PersonData entity) {
        return personDataRepository.save(entity);
    }

    @Override
    public PersonData findById(Long id) {
        return personDataRepository.findById(id).get();
    }

    @Override
    public List<PersonData> findAll() {
        return personDataRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        personDataRepository.deleteById(id);
    }
}
