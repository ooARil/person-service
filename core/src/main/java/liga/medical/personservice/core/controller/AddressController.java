package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import liga.medical.personservice.core.model.entity.Address;
import liga.medical.personservice.core.service.api.AddressService;
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
@RequestMapping("/address")
@Api(value = "API для получения мест регистрации пациента")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/add")
    @ApiOperation(value = "Добавление места регистрации пациента в контактные данные")
    public Address addAddress(@RequestBody Address address) {
        addressService.save(address);
        return address;
    }

    @GetMapping("/get/{id}")
    @ApiOperation(value = "Получение мест регистрации пациента по ID")
    public Address getAddressById(@PathVariable
                                      @ApiParam(name = "id", value = "Address id", example = "1") Long id) {
        return addressService.findById(id);
    }

    @GetMapping("/get")
    @ApiOperation(value = "Получение списка мест регистрации пациента")
    public List<Address> getAllAddresses() {
        return addressService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Удаление места регистрации пациента по ID")
    public void deleteAddressById(@PathVariable
                                      @ApiParam(name = "id", value = "Address id", example = "1") Long id) {
        addressService.deleteById(id);
    }
}
