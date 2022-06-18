package za.ac.cput.repository.name;
/*
 * Entity for NameRepository
 * Author: Smangele Witness Mabaso (220047154)
 * Date: 14 June 2022
 */
import za.ac.cput.domain.name.Name;

import java.util.*;

public class NameRepository {

        private final List<Name> nameList;
        private static NameRepository NAME_REPOSITORY;

        private NameRepository() {
            this.nameList = new ArrayList<>();
        }

        public static NameRepository nameRepository() {
            if (NAME_REPOSITORY == null)
                NAME_REPOSITORY = new NameRepository();
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
