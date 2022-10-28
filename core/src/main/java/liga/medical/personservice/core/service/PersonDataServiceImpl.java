package liga.medical.personservice.core.service;

import liga.medical.personservice.core.mapper.PersonDataMapper;
import liga.medical.personservice.core.model.pojo.PersonData;
import liga.medical.personservice.core.service.api.PersonDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonDataServiceImpl implements PersonDataService {

    @Autowired
    PersonDataMapper personDataMapper;

    @Override
    public long save(PersonData entity) {
        return personDataMapper.save(entity);
    }

    @Override
    public PersonData findById(Long id) {
        return personDataMapper.findById(id);
    }

    @Override
    public List<PersonData> findAll() {
        return personDataMapper.findAll();
    }

    @Override
    public void deleteById(Long id) {
        personDataMapper.deleteById(id);
    }
}
