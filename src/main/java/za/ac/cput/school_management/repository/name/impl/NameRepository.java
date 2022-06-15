package za.ac.cput.school_management.repository.name.impl;

import za.ac.cput.school_management.domain.name.Name;
import za.ac.cput.school_management.repository.name.INameRepository;
import java.util.*;

public class NameRepository implements INameRepository {
    private final List<Name> nameList;
    private static NameRepository NAME_REPOSITORY;


    private NameRepository() {
        this.nameList = new ArrayList<>();
    }

    public static NameRepository nameRepository() {
        if (NAME_REPOSITORY == null) {
            NAME_REPOSITORY = new NameRepository();
        }
        return NAME_REPOSITORY;
    }

    @Override
    public Name save(Name name) {
       Optional<Name> read = read(name.getFirstName());
       if (read.isPresent()){
           delete(read.get());
       }
       this.nameList.add(name);
  return name;
    }

    @Override
    public Optional<Name> read(String firstName) {
        return this.nameList.stream().filter(n -> n.getFirstName().equalsIgnoreCase(firstName))
                .findFirst();

    }

    @Override
    public Name update(Name name) {
        Optional<Name> read = read(name.getFirstName());
        if (read.isPresent()) {
            delete(read.get());
            save(name);
        }
        return name;
    }

    @Override
    public void delete(Name name) {
        this.nameList.remove(name);
    }

    @Override
    public Set<Name> findAll() {
        return null;
    }
}