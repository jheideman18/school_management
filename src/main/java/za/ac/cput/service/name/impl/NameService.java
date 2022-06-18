package za.ac.cput.service.name.impl;
/* NameService.java
 * Author: Smangele Witness Mabaso (220047154)
 * Date: 15 June 2022
 */


import org.springframework.stereotype.Service;
import za.ac.cput.domain.name.Name;
import za.ac.cput.repository.name.NameRepository;
import za.ac.cput.service.name.INameService;

import java.util.List;
import java.util.Optional;

@Service
public class NameService implements INameService {
    
        private  NameRepository repository;
        private static NameService SERVICE;

        private NameService() {
        this.repository= NameRepository.nameRepository();

        }

        public static NameService getService() {
        if (SERVICE == null)
        SERVICE = new NameService();
        return SERVICE;
        }

@Override
public Name save(Name name) {
        return this.repository.save(name);
        }

@Override
public Optional<Name> read(String firstName) {
        return this.repository.read(firstName);
        }

@Override
public void delete(Name name) {
        this.repository.delete(name);
        }
        public List<Name> findAll(){
                return this.repository.findAll();
        }
}


