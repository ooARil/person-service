package liga.medical.personservice.core.service;

import liga.medical.personservice.core.model.entity.Address;
import liga.medical.personservice.core.repos.api.AddressRepository;
import liga.medical.personservice.core.service.api.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Address save(Address entity) {
        return addressRepository.save(entity);
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id).get();
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }
}