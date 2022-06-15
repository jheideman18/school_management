package za.ac.cput.school_management.repository.address;

import za.ac.cput.school_management.domain.address.Country;
import za.ac.cput.school_management.repository.IRepository;

import java.util.List;

public interface ICountryRepository extends IRepository<Country, String> {
    List<Country> findAll();
}
