package Repository;

import java.lang.RuntimeException;
import java.lang.Exception;
import java.lang.Throwable;

public class DuplicateEntityException extends RuntimeException {
    public DuplicateEntityException(String errMessage) {
        super(errMessage);
    }
}