package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import liga.medical.personservice.core.model.entity.MedicalCard;
import liga.medical.personservice.core.service.api.MedicalCardService;
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
@RequestMapping("/medical_card")
@Api(value = "API для получении медицинской карты пациента")
public class MedicalCardController {

    @Autowired
    MedicalCardService medicalCardService;

    @PostMapping("/add")
    @ApiOperation(value = "Добавление медицинской карты пациента")
    public MedicalCard addMedicalCard(@RequestBody MedicalCard medicalCard) {
        medicalCardService.save(medicalCard);
        return medicalCard;
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "Получение медицинской карты по её ID")
    public MedicalCard getMedicalCardById(@PathVariable
                                              @ApiParam(name = "id", value = "MedicalCard id", example = "1") Long id) {
        return medicalCardService.findById(id);
    }

    @GetMapping("/get")
    @ApiOperation(value = "Получение списка медицинских карт")
    public List<MedicalCard> getAllMedicalCards() {
        return medicalCardService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Удаление медицнской карты по ее ID")
    public void deleteMedicalCardByById(@PathVariable
                                            @ApiParam(name = "id", value = "MedicalCard id", example = "1") Long id) {
        medicalCardService.deleteById(id);
    }
}
