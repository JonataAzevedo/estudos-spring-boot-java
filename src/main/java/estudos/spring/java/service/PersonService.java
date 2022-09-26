package estudos.spring.java.service;

import estudos.spring.java.exceptions.UnsupportedMethOperationException;
import estudos.spring.java.model.entities.Person;
import estudos.spring.java.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public static Double covertToDouble(String strNumber) {
        if (strNumber == null) return 0d;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 1.0d;
    }

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public Double soma(String numberOne, String numberTwo) {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMethOperationException("Please set a numeric value!");
        }

        return covertToDouble(numberOne) + covertToDouble(numberTwo);
    }

    public Person create(Person person) {
        Person person1 = new Person();
        person1.setFirstName(person.getFirstName());
        person1.setLastName(person.getLastName());
        person1.setAddress(person.getAddress());
        person1.setGender(person.getGender());
        return personRepository.save(person1);
    }

    public Person findById(Integer id) {
        Optional<Person> person = personRepository.findById(id);
        return person.get();
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person update(Integer id, Person person) {
        Optional<Person> person1 = personRepository.findById(id);

        Person newPersonUpdate = person1.get();
        newPersonUpdate.setFirstName(person.getFirstName());
        newPersonUpdate.setLastName(person.getLastName());
        newPersonUpdate.setAddress(person.getAddress());
        newPersonUpdate.setGender(person.getGender());
        return personRepository.save(newPersonUpdate);
    }

    public void deleteById(Integer id){
        personRepository.deleteById(id);
    }

}