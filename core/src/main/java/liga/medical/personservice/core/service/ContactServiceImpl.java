package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.entity.Contact;
import liga.medical.personservice.core.repos.api.ContactRepository;
import liga.medical.personservice.core.service.api.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact save(Contact entity) {
        return contactRepository.save(entity);
    }

    @Override
    public Contact findById(Long id) {
        return contactRepository.findById(id).get();
    }

    @Override
    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }
}
