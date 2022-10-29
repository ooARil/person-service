package liga.medical.personservice.core.controller;

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
public class IllnessController {

    @Autowired
    IllnessService illnessService;

    @PostMapping("/add")
    public Illness addIllness(@RequestBody Illness illness) {
        illnessService.save(illness);
        return illness;
    }

    @GetMapping("/get/{id}")
    public Illness getIllnessById(@PathVariable Long id) {
        return illnessService.findById(id);
    }

    @GetMapping("/get")
    public List<Illness> getAllIllnesses() {
        return illnessService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteIllnessById(@PathVariable Long id) {
        illnessService.deleteById(id);
    }
}
