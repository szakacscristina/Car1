package Domain;

import java.lang.Exception;
import java.lang.RuntimeException;

public class ValidatorException extends RuntimeException {
    public ValidatorException (String msg){
        super(msg);
    }
}