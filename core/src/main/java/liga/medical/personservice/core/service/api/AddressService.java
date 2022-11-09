package liga.medical.personservice.core.service.api;

import liga.medical.personservice.core.model.Address;

import java.util.List;

public interface AddressService {

    Address save(Address entity);

    Address findById(Long id);

    List<Address> findAll();

    void deleteById(Long id);
}
