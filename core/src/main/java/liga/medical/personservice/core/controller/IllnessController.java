package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import liga.medical.personservice.core.model.Illness;
import liga.medical.personservice.core.service.api.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/{id}")
    @ApiOperation(value = "Получение болезни из медицинской картой по ID")
    public Illness findById(@PathVariable
                                      @ApiParam(name = "id", value = "Illness id", example = "1") Long id) {
        return illnessService.findById(id);
    }

    @GetMapping
    @ApiOperation(value = "Получени списка болезней из медицинской карты")
    public List<Illness> findAll() {
        return illnessService.findAll();
    }

    @PutMapping
    public Illness update(@RequestBody Illness illness) {
        return illnessService.save(illness);
    }
}
