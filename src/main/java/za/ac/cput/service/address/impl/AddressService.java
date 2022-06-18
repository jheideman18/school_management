package za.ac.cput.service.address.impl;
/*
Jody Heideman 219307725
AddressService.java
11/06/22
 */
import za.ac.cput.domain.address.Address;
import za.ac.cput.repository.address.AddressRepository;
import za.ac.cput.service.address.IAddressService;

import java.util.List;
import java.util.Optional;

public class AddressService implements IAddressService {
    private final AddressRepository repository;
    private static IAddressService SERVICE;

    private AddressService(){
        this.repository = AddressRepository.addressRepository();
    }

    public static IAddressService getService(){
        if(SERVICE == null)
            SERVICE = new AddressService();
        return SERVICE;
    }
    @Override
    public Address save(Address address) {
        return this.repository.save(address);
    }

    @Override
    public Optional<Address> read(String s) {
        return this.repository.read(s);
    }

    @Override
    public void delete(Address address) {
        this.repository.delete(address);
    }
    @Override
    public List<Address> findAll() {
        return this.repository.findAll();
    }
}
