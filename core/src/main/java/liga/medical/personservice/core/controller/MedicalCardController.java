package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import liga.medical.personservice.core.model.MedicalCard;
import liga.medical.personservice.core.service.api.MedicalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/{id}")
    @ApiOperation(value = "Получение медицинской карты по её ID")
    public MedicalCard findById(@PathVariable
                                              @ApiParam(name = "id", value = "MedicalCard id", example = "1") Long id) {
        return medicalCardService.findById(id);
    }

    @GetMapping
    @ApiOperation(value = "Получение списка медицинских карт")
    public List<MedicalCard> findAll() {
        return medicalCardService.findAll();
    }

    @PutMapping
    public MedicalCard update(@RequestBody MedicalCard medicalCard) {
        return medicalCardService.save(medicalCard);
    }
}
