package za.ac.cput.repository.address;
/*
Jody Heideman 219307725
IAddressRepository.java
11/06/22
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.address.Address;
import za.ac.cput.repository.IRepository;

import java.util.List;
@Repository
public interface IAddressRepository extends IRepository<Address, String> {

}
