package estudos.spring.java.controller;

import estudos.spring.java.model.entities.Person;
import estudos.spring.java.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person){
        Person person1 = personService.create(person);

        return new ResponseEntity<>(person1, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Person> findById(@PathVariable Integer id) {

        return new ResponseEntity<>(personService.findById(id), HttpStatus.OK);
    }

    @GetMapping
    public List<Person> findAll(){
        return personService.findAll();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Person> update(@PathVariable Integer id, @RequestBody Person person){
        Person person1 = personService.update(id, person);

        return new ResponseEntity<>(person1, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Person> delete(@PathVariable Integer id){
        personService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}