package Repository;
import java.lang.Exception;
import java.lang.RuntimeException;

public class ValidatorExceptionRepository extends RuntimeException {
    public ValidatorExceptionRepository (String msg){
        super(msg);
}
    }
