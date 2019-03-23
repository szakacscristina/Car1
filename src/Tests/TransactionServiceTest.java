package Tests;

import Domain.Transaction;
import Domain.TransactionValidator;
import Repository.TransactionRepository;
import Service.TransactionService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TransactionServiceTest {

    @Test
    void addOrUpdateServiceShouldAddTransaction() {
        TransactionValidator validator = new TransactionValidator();
        TransactionRepository repository = new TransactionRepository(validator);
        TransactionService transactionService = new TransactionService(repository);
        Transaction transaction1 = new Transaction("1","1","1","12.45.6789","14",654,56,10);
        Transaction transaction2 = new Transaction("2","2","2","23,56,7654","15",765,45,10);

        transactionService.addOrUpdate("1","1","1",567,"23.56.1234","13");
        transactionService.addOrUpdate("2","2","2",567,"12.45.5678","16");
        assertEquals(2, transactionService.getAll().size());
        assertEquals(transaction1, transactionService.getAll().get(0));
        assertEquals(transaction2, transactionService.getAll().get(1));
    }

    @Test
    void updateServiceShouldUpdateTransaction() {
        TransactionValidator validator = new TransactionValidator();
        TransactionRepository repository = new TransactionRepository(validator);
        TransactionService transactionService = new TransactionService(repository);
        Transaction transaction1 = new Transaction(1, 1, 1, 5, "12.12.2012", "10:00");
        Transaction transaction2 = new Transaction(2, 2, 1, 6, "12.12.2012", "10:00");

        transactionService.update(1, 1, 1, 5, "12.12.2012", "10:00");
        transactionService.update(2, 2, 1, 6, "12.12.2012", "10:00");
        assertEquals(2, transactionService.getAll().size());
        assertEquals(transaction1, transactionService.getAll().get(0));
        assertEquals(transaction2, transactionService.getAll().get(1));
    }

    @Test
    void deleteServiceShouldRemoveTransaction() {
        TransactionValidator validator = new TransactionValidator();
        TransactionRepository repository = new TransactionRepository(validator);
        TransactionService transactionService = new TransactionService(repository);
        Transaction transaction1 = new Transaction(1, 1, 1, 5, "12.12.2012", "10:00");

        transactionService.add(1, 1, 1, 5, "12.12.2012", "10:00");
        transactionService.delete(1);
        assertEquals(0, transactionService.getAll().size());
        assertTrue(transactionService.getAll().size() == 0);
    }

    @Test
    void getAllServiceShouldGetAllTransactions() {
        TransactionValidator validator = new TransactionValidator();
        TransactionRepository repository = new TransactionRepository(validator);
        TransactionService transactionService = new TransactionService(repository);
        Transaction transaction3 = new Transaction(5, 1, 1, 5, "12.12.2012", "10:00 1");
        Transaction transaction4 = new Transaction(6, 1, 1, 5, "12.12.2012", "10:00 2");

        transactionService.add(5, 1, 1, 5, "12.12.2012", "10:00 1");
        transactionService.add(6, 1, 1, 5, "12.12.2012", "10:00 2");
        assertEquals(transaction3, transactionService.getAll().get(0));
        assertEquals(transaction4, transactionService.getAll().get(1));
        assertTrue(transactionService.getAll().size() == 2);
    }
}

