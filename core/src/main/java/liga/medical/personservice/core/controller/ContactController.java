package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.entity.Contact;
import liga.medical.personservice.core.service.api.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping(path = "/add", produces = "application/json")
    public Contact addContact(@RequestBody Contact contact) {
        contactService.save(contact);
        return contact;
    }

    @GetMapping("/get/{id}")
    public Contact getContactById(@PathVariable Long id) {
        return contactService.findById(id);
    }

    @GetMapping("/get")
    public List<Contact> getAllContacts() {
        return contactService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteContactById(@PathVariable Long id) {
        contactService.deleteById(id);
    }
}
