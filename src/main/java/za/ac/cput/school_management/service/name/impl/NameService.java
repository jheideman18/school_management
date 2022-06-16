package za.ac.cput.school_management.service.name.impl;



import za.ac.cput.school_management.domain.name.Name;
import za.ac.cput.school_management.repository.name.impl.NameRepository;
import za.ac.cput.school_management.service.name.INameService;

import java.util.Optional;


public class NameService implements INameService {
    
    private final NameRepository repository;
private static NameService SERVICE;

private NameService() {
        this.repository= NameRepository.nameRepository();

        }

private static NameService getService() {
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

}

