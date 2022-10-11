package estudos.spring.java.controller;

import estudos.spring.java.model.entities.PersonVO;
import estudos.spring.java.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<PersonVO> create(@RequestBody PersonVO personVO){
        PersonVO personVO1 = personService.create(personVO);

        return new ResponseEntity<>(personVO1, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PersonVO> findById(@PathVariable Integer id) {

        return new ResponseEntity<>(personService.findById(id), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonVO> findAll(){
        return personService.findAll();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PersonVO> update(@PathVariable Integer id, @RequestBody PersonVO personVO){
        PersonVO personVO1 = personService.update(id, personVO);

        return new ResponseEntity<>(personVO1, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")

    public ResponseEntity<PersonVO> delete(@PathVariable Integer id){
        personService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}