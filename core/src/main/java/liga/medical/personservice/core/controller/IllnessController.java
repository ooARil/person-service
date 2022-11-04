package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import liga.medical.personservice.core.model.entity.Illness;
import liga.medical.personservice.core.service.api.IllnessService;
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
@RequestMapping("/illness")
@Api(value = "API для получения болезней из медицинской карты пациента")
public class IllnessController {

    @Autowired
    IllnessService illnessService;

    @PostMapping("/add")
    @ApiOperation(value = "Добавление болезни в медицинскую карту")
    public Illness addIllness(@RequestBody Illness illness) {
        illnessService.save(illness);
        return illness;
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "Получение болезни из медицинской картой по ID")
    public Illness getIllnessById(@PathVariable
                                      @ApiParam(name = "id", value = "Illness id", example = "1") Long id) {
        return illnessService.findById(id);
    }

    @GetMapping("/get")
    @ApiOperation(value = "Получени списка болезней из медицинской карты")
    public List<Illness> getAllIllnesses() {
        return illnessService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Удаление болезни из медицинской карты по ID")
    public void deleteIllnessById(@PathVariable
                                      @ApiParam(name = "id", value = "Illness id", example = "1")Long id) {
        illnessService.deleteById(id);
    }
}
