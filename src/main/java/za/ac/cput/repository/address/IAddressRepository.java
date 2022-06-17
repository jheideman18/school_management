package za.ac.cput.repository.address;

import za.ac.cput.domain.address.Address;
import za.ac.cput.repository.IRepository;

import java.util.List;

public interface IAddressRepository extends IRepository<Address, String> {

    List<Address> findAll();
}
