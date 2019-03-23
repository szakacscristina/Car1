package Tests;
import Domain.Transaction;

        import Domain.TransactionValidator;
        import org.junit.jupiter.api.Test;

        import javax.management.RuntimeErrorException;

        import static org.junit.jupiter.api.Assertions.*;

class TransactionValidatorTest {

    @Test
    public void validateTransaction() {

        TransactionValidator transactionV = new TransactionValidator();
        Transaction transaction = new Transaction("1", "1","1","12.34.6789","12",345,67,10);
        transactionV.validate(transaction);
        //assertThrows(RuntimeErrorException.class, ()-> transactionV.validate(transaction));
        assertDoesNotThrow(()->transactionV.validate(transaction));

    }
}