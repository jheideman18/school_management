package za.ac.cput.school_management.repository.name.impl;

import za.ac.cput.school_management.domain.name.Name;
import za.ac.cput.school_management.repository.name.INameRepository;
import java.util.*;

public class NameRepositoryImpl implements INameRepository {
    private final List<Name> nameList;
    private static NameRepositoryImpl NAME_REPOSITORY;


    private NameRepositoryImpl() {
        this.nameList = new ArrayList<>();
    }

    public static NameRepositoryImpl nameRepository() {
        if (NAME_REPOSITORY == null) //{
            NAME_REPOSITORY = new NameRepositoryImpl();
        //}
        return NAME_REPOSITORY;
    }


    public Name save(Name name) {
       Optional<Name> read = read(name.getFirstName());
       if (read.isPresent()){
           delete(read.get());
       }
       this.nameList.add(name);
  return name;
    }

    public Optional<Name> read(String firstName) {
        return this.nameList.stream().filter(n -> n.getFirstName().equalsIgnoreCase(firstName))
                .findFirst();

    }


    public void delete(Name name) {
        this.nameList.remove(name);
    }

    public List<Name> findAll() {
        return this.nameList;
    }

}