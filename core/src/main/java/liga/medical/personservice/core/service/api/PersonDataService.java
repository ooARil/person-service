package liga.medical.personservice.core.service.api;

import liga.medical.personservice.core.model.pojo.PersonData;

import java.util.List;

public interface PersonDataService {

    long save(PersonData entity);

    PersonData findById(Long id);

    List<PersonData> findAll();

    void deleteById(Long id);
}
