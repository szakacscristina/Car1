package Service;
import java.lang.Exception;
import java.lang.RuntimeException;

    public class ValidatorExceptionService extends RuntimeException {
        public ValidatorExceptionService (String msg){
            super(msg);
        }
    }



