package za.ac.cput.service.address;
/*
Jody Heideman 219307725
IAddressService.java
14/06/22
 */
import za.ac.cput.domain.address.Address;
import za.ac.cput.service.IService;

import java.util.List;

public interface IAddressService extends IService<Address, String> {

    List<Address> findAll();
}
