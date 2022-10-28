package liga.medical.personservice.core.controller;

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
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/add")
    public Address addAddress(@RequestBody Address address) {
        addressService.save(address);
        return address;
    }

    @GetMapping("/get/{id}")
    public Address getAddressById(@PathVariable Long id) {
        return addressService.findById(id);
    }

    @GetMapping("/get")
    public List<Address> getAllAddresses() {
        return addressService.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAddressById(@PathVariable Long id) {
        addressService.deleteById(id);
    }
}
