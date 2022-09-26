package estudos.spring.java.repository;

import estudos.spring.java.model.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository <Person, Integer> {
}
