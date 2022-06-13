package za.ac.cput.school_management.repository;

import za.ac.cput.school_management.domain.Address;

import java.util.List;

public interface IAddressRepository extends IRepository<Address, String> {

    List<Address> findAll();
}
