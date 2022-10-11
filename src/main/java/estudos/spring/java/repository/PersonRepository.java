package estudos.spring.java.repository;

import estudos.spring.java.model.entities.PersonVO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository <PersonVO, Integer> {
}
