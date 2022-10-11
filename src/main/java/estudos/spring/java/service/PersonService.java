package estudos.spring.java.service;

import estudos.spring.java.exceptions.UnsupportedMethOperationException;
import estudos.spring.java.model.entities.PersonVO;
import estudos.spring.java.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonVO create(PersonVO personVO) {

        PersonVO personVO1 = new PersonVO();

        personVO1.setFirstName(personVO.getFirstName());
        personVO1.setLastName(personVO.getLastName());
        personVO1.setAddress(personVO.getAddress());
        personVO1.setGender(personVO.getGender());

        return personRepository.save(personVO1);
    }

    public PersonVO findById(Integer id) {
        Optional<PersonVO> person = personRepository.findById(id);
        return person.get();
    }

    public List<PersonVO> findAll() {
        return personRepository.findAll();
    }

    public PersonVO update(Integer id, PersonVO personVO) {
        Optional<PersonVO> person1 = personRepository.findById(id);

        PersonVO newPersonUpdateVO = person1.get();
        newPersonUpdateVO.setFirstName(personVO.getFirstName());
        newPersonUpdateVO.setLastName(personVO.getLastName());
        newPersonUpdateVO.setAddress(personVO.getAddress());
        newPersonUpdateVO.setGender(personVO.getGender());
        return personRepository.save(newPersonUpdateVO);
    }

    public void deleteById(Integer id){
        personRepository.deleteById(id);
    }

}