package za.ac.cput.service;

import za.ac.cput.domain.address.Address;

import java.util.List;

public interface IAddressService extends IService<Address, String> {

    List<Address> findAll();
}
