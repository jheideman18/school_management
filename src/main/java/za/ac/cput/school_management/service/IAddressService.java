package za.ac.cput.school_management.service;

import za.ac.cput.school_management.domain.address.Address;
import za.ac.cput.school_management.service.IService;

import java.util.List;

public interface IAddressService extends IService<Address, String> {

    List<Address> findAll();
}
