package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@Api(value = "API для получении информации о пациенте")
public class PersonDataController {

    @Autowired
    PersonDataService personDataService;

    @PostMapping("/add")
    @ApiOperation(value = "Добавление нового пациента")
    public PersonData addIllness(@RequestBody PersonData personData) {
        personDataService.save(personData);
        return personData;
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "Получение пациента по его ID")
    public PersonData getPersonDataById(@PathVariable
                                            @ApiParam(name = "id", value = "PersonData id", example = "1") Long id) {
        return personDataService.findById(id);
    }

    @GetMapping("/get")
    @ApiOperation(value = "Получение списка пациентов")
    public List<PersonData> getAllPersonData() {
        return personDataService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Удаление пациента по его ID")
    public void deletePersonDataById(@PathVariable
                                         @ApiParam(name = "id", value = "PersonData id", example = "1") Long id) {
        personDataService.deleteById(id);
    }
}
