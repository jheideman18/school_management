package za.ac.cput.repository.name;
/*
 * Entity for INameRepository
 * Author: Smangele Witness Mabaso (220047154)
 * Date: 14 June 2022
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.name.Name;
import za.ac.cput.repository.IRepository;

import java.util.List;
@Repository
public interface INameRepository extends JpaRepository<Name, String> {

}
