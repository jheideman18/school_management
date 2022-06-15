package za.ac.cput.school_management.service.name.impl;


import za.ac.cput.school_management.domain.name.Name;
import za.ac.cput.school_management.repository.name.impl.NameRepositoryImpl;
import za.ac.cput.school_management.service.name.INameService;
import java.util.Optional;


public class NameServiceImpl implements INameService {
    private final NameRepositoryImpl repository;
    private static NameServiceImpl SERVICE;

    private NameServiceImpl() {
        this.repository= NameRepositoryImpl.nameRepository();

    }

    private static INameService getService() {
        if (SERVICE == null)
            SERVICE = new NameServiceImpl();
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

