package liga.medical.personservice.core.service.api;

import liga.medical.personservice.core.model.Contact;

import java.util.List;

public interface ContactService {

    Contact save(Contact entity);

    Contact findById(Long id);

    List<Contact> findAll();

    void deleteById(Long id);
}
