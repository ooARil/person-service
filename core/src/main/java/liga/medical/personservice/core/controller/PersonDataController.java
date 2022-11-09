package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import liga.medical.personservice.core.model.PersonData;
import liga.medical.personservice.core.service.api.PersonDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @PostMapping
    @ApiOperation(value = "Добавление нового пациента")
    public PersonData save(@RequestBody PersonData personData) {
        personDataService.save(personData);
        return personData;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Получение пациента по его ID")
    public PersonData findById(@PathVariable
                                            @ApiParam(name = "id", value = "PersonData id", example = "1") Long id) {
        return personDataService.findById(id);
    }

    @GetMapping
    @ApiOperation(value = "Получение списка пациентов")
    public List<PersonData> findAll() {
        return personDataService.findAll();
    }

    @PutMapping
    public PersonData update(@RequestBody PersonData personData) {
        return personDataService.save(personData);
    }
}
