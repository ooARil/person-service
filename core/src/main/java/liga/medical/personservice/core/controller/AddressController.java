package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import liga.medical.personservice.core.model.Address;
import liga.medical.personservice.core.service.api.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
@Api(value = "API для получения мест регистрации пациента")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Получение мест регистрации пациента по ID")
    public Address findById(@PathVariable
                                      @ApiParam(name = "id", value = "Address id", example = "1") Long id) {
        return addressService.findById(id);
    }

    @GetMapping
    @ApiOperation(value = "Получение списка мест регистрации пациента")
    public List<Address> findAll() {
        return addressService.findAll();
    }

    @PutMapping
    public Address update(@RequestBody Address address) {
        return addressService.save(address);
    }
}
