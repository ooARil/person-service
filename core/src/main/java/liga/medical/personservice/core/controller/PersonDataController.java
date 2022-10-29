package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.model.pojo.PersonData;
import liga.medical.personservice.core.service.api.PersonDataService;
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
@RequestMapping("/person_data")
public class PersonDataController {

    @Autowired
    PersonDataService personDataService;

    @PostMapping("/add")
    public PersonData addIllness(@RequestBody PersonData personData) {
        personDataService.save(personData);
        return personData;
    }

    @GetMapping("/get/{id}")
    public PersonData getPersonDataById(@PathVariable Long id) {
        return personDataService.findById(id);
    }

    @GetMapping("/get")
    public List<PersonData> getAllPersonData() {
        return personDataService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deletePersonDataById(@PathVariable Long id) {
        personDataService.deleteById(id);
    }
}
