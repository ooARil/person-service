package liga.medical.personservice.core.controller;

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
public class MedicalCardController {

    @Autowired
    MedicalCardService medicalCardService;

    @PostMapping("/add")
    public MedicalCard addMedicalCard(@RequestBody MedicalCard medicalCard) {
        medicalCardService.save(medicalCard);
        return medicalCard;
    }

    @GetMapping("/get/{id}")
    public MedicalCard getMedicalCardById(@PathVariable Long id) {
        return medicalCardService.findById(id);
    }

    @GetMapping("/get")
    public List<MedicalCard> getAllMedicalCards() {
        return medicalCardService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMedicalCardByById(@PathVariable Long id) {
        medicalCardService.deleteById(id);
    }
}
