package estudos.spring.java.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMethOperationException extends RuntimeException{

    public UnsupportedMethOperationException(String ex){
        super(ex);
    }

    @Serial
    private static final long serialVersionUID = 1L;
}
