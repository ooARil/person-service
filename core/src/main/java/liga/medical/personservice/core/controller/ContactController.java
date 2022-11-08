package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(value = "API для получения контакнтных данных пациента")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping(path = "/add", produces = "application/json")
    @ApiOperation(value = "Добавление контакнтных данных")
    public Contact addContact(@RequestBody Contact contact) {
        contactService.save(contact);
        return contact;
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "Получение контакнтных данных по ID")
    public Contact getContactById(@PathVariable
                                      @ApiParam(name = "id", value = "Contact id", example = "1") Long id) {
        return contactService.findById(id);
    }

    @GetMapping("/get")
    @ApiOperation(value = "Получение списка контактных данных")
    public List<Contact> getAllContacts() {
        return contactService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Удаление контактных данных по ID")
    public void deleteContactById(@PathVariable
                                      @ApiParam(name = "id", value = "Contact id", example = "1") Long id) {
        contactService.deleteById(id);
    }
}
