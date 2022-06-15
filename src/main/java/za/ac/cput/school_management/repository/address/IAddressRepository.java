package za.ac.cput.school_management.repository.address;

import za.ac.cput.school_management.domain.address.Address;
import za.ac.cput.school_management.repository.IRepository;

import java.util.List;

public interface IAddressRepository extends IRepository<Address, String> {

    List<Address> findAll();
}
