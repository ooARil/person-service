package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import liga.medical.personservice.core.model.Contact;
import liga.medical.personservice.core.service.api.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/{id}")
    @ApiOperation(value = "Получение контакнтных данных по ID")
    public Contact findById(@PathVariable
                                      @ApiParam(name = "id", value = "Contact id", example = "1") Long id) {
        return contactService.findById(id);
    }

    @GetMapping
    @ApiOperation(value = "Получение списка контактных данных")
    public List<Contact> findAll() {
        return contactService.findAll();
    }

    @PutMapping
    public Contact update(@RequestBody Contact contact) {
        return contactService.save(contact);
    }
}
