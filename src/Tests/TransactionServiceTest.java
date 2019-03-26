package Tests;

import Domain.Transaction;
import Domain.TransactionValidator;
import Repository.CarRepository;
import Repository.IRepository;
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
    void removeServiceShouldRemoveTransaction() {
        TransactionValidator validator = new TransactionValidator();
        TransactionRepository repository = new TransactionRepository(validator);
        TransactionService transactionService = new TransactionService(repository);
        Transaction transaction1 = new Transaction("1","1","1","12.45.6789","12",345,56,10);

        transactionService.addOrUpdate("1","1","1",456,"12.46.6789","14");
        transactionService.remove("1");
        assertEquals(0, transactionService.getAll().size());
        assertTrue(transactionService.getAll().size() == 0);
    }

    @Test
    void getAllServiceShouldGetAllTransactions() {
        TransactionValidator validator = new TransactionValidator();
        TransactionRepository repository = new TransactionRepository(validator);
        TransactionService transactionService = new TransactionService(repository);
        Transaction transaction3 = new Transaction("3","3","3","12.56.7890","15",466,23,10);
        Transaction transaction4 = new Transaction("4","4","4","15.76.3456","22",765,78,10);

        transactionService.addOrUpdate("1","1","1",764,"12.75.3456","20");
        transactionService.addOrUpdate("1","1","1",754,"12.76.3456","22");
        assertEquals(transaction3, transactionService.getAll().get(0));
        assertEquals(transaction4, transactionService.getAll().get(1));
        assertTrue(transactionService.getAll().size() == 2);
    }
}

