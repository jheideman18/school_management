//package za.ac.cput.school_management.service.name.impl;
//
//
//import org.springframework.stereotype.Service;
//import za.ac.cput.school_management.domain.name.Name;
//import za.ac.cput.school_management.service.name.INameService;
//import java.util.Optional;
//
//
////@Service
//public class NameService implements INameService {
//    private final NameRepository repository;
//    private static NameService SERVICE;
//
//    private NameService() {
//        this.repository= NameRepository.nameRepository();
//
//    }
//
//    private static NameService getService() {
//        if (SERVICE == null) {
//            SERVICE = new NameService();
//        }
//        return SERVICE;
//    }
//
//    @Override
//    public Name save(Name name) {
//        return this.repository.save(name);
//    }
//
//    @Override
//    public Optional<Name> read(String s) {
//        return this.repository.read(s);
//    }
//
//    @Override
//    public void delete(Name name) {
//        this.repository.delete(name);
//    }
//
//   /* @Override
//    public Name update(Name name) {
//        if (this.repository.existsById(name.getFirstName())) {
//            return this.repository.save(name);
//        }
//        return null;
//
//    }
//    @Override
//    public Set<Name> getAll() {
//        return this.repository.findAll().stream().collect(Collectors.toSet());
//    }
//
//    @Override
//    public Name create(Name name) {
//        return this.repository.save(name);
//    }
//    @Override
//    public boolean delete(String s) {
//        this.repository.deleteById(s);
//        if (this.repository.existsById(s)) return false;
//        else return true;
//    } */
//}

