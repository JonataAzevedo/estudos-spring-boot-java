package estudos.spring.java.controller;

import estudos.spring.java.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/home")
public class MathController {

    @Autowired
    private OperationService operationService;

    @GetMapping(path = "/soma/{numberOne}/{numberTwo}")
    public Double soma(@PathVariable String numberOne, @PathVariable String numberTwo) {

        return operationService.soma(numberOne, numberTwo);
    }

    @GetMapping(path = "/sub/{numberOne}/{numberTwo}")
    public Double sub(@PathVariable String numberOne, @PathVariable String numberTwo){

        return operationService.sub(numberOne, numberTwo);
    }

    @GetMapping(path = "/mult/{numberOne}/{numberTwo}")
    public Double mult(@PathVariable String numberOne, @PathVariable String numberTwo){

        return operationService.mult(numberOne, numberTwo);
    }

    @GetMapping(path = "/div/{numberOne}/{numberTwo}")
    public Double div(@PathVariable String numberOne, @PathVariable String numberTwo){

        return operationService.div(numberOne, numberTwo);
    }

    @GetMapping(path = "/media/{numberOne}/{numberTwo}")
    public Double media(@PathVariable String numberOne, @PathVariable String numberTwo){

        return operationService.media(numberOne, numberTwo);
    }

    @GetMapping(path = "/raiz/{number}")
    public Double raiz(@PathVariable String number){

        return operationService.raiz(number);
    }
}