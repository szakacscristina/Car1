package Tests;

import Domain.Transaction;
import Domain.TransactionValidator;
import Repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

    class TransactionRepositoryTest {

        @Test
        void findByIdWithExistingIdShouldReturnCorrectTransaction() {
            TransactionValidator validator = new TransactionValidator();
            TransactionRepository repository = new TransactionRepository(validator);
            Transaction transaction = new Transaction("1","1","1","12.34.5678","12",234,45,10);

            repository.add(transaction);
            Transaction transactionToFind = repository.getById("1");
            assertNotNull(transactionToFind, "Returned null for existing id!");
            assertEquals(transactionToFind.getId(), 1, String.format("Return id %s instead of correct id =1", transactionToFind.getId()));
            assertEquals(transactionToFind.getIdCar(), 1, String.format("Return medicine id %s instead of correct idMedicine=1 ", transactionToFind.getIdCar()));
            assertEquals(transactionToFind.getIdClientCard(), 1, String.format("Return client card id %s instead of correct idClientCard=1 ", transactionToFind.getIdClientCard()));
            assertEquals(transactionToFind.getPieceTotal(), 5, String.format("Return number of medicine %s instead of correct numberMedicine=5", transactionToFind.getPieceTotal()));
            assertEquals(transactionToFind.getDate(), "12.12.2012", String.format("Return date %s instead of correct date=12.12.2012", transactionToFind.getDate()));
            assertEquals(transactionToFind.getTime(), "10:00", String.format("Return time %s instead of correct time=10:00", transactionToFind.getTime()));
        }

        @Test
        void addShouldAddTransactions() {
            TransactionValidator validator = new TransactionValidator();
            TransactionRepository repository = new TransactionRepository(validator);
            Transaction transaction1 = new Transaction("1", "1","1","12.56.3456","12",234,546,10);
            Transaction transaction2 = new Transaction("2","2","2","12.45.6789","14",567,89,10);
            Transaction transaction1Duplicate = new Transaction("3","3","3","34.56.7890","15",678,890,10);

            repository.add(transaction1);
            repository.add(transaction2);
            List<Transaction> allTransactions = repository.getAll();
            assertTrue(allTransactions.size() == 2);
            assertEquals(transaction1, allTransactions.get(0));
            assertEquals(transaction2, allTransactions.get(1));

            try {
                repository.add(transaction1Duplicate);
                fail("Exception not thrown for duplicate transaction id!");
            } catch (RuntimeException rex) {
                assertTrue(true);
            }
        }

        @Test
        void updateShouldUpdateTransactions() {
            TransactionValidator validator = new TransactionValidator();
            TransactionRepository repository = new TransactionRepository(validator);
            Transaction transaction1 = new Transaction("1","1","1","34.56.7890","16",678,78,10);
            Transaction transaction2 = new Transaction("2","2","2","56.78.1234","18",234,67,10);
            Transaction transaction1Duplicate = new Transaction("3","3","3","34.56.7890","19",678,90,10);

            repository.update(transaction1);
            repository.update(transaction2);
            List<Transaction> allTransactions = repository.getAll();
            assertEquals(2, allTransactions.size());
            assertEquals(transaction1, allTransactions.get(0));
            assertEquals(transaction2, allTransactions.get(1));

            try {
                repository.update(transaction1Duplicate);
                fail("Exception not thrown for duplicate transaction id!");
            } catch (RuntimeException rex) {
                assertTrue(true);
            }
        }

        @Test
        void deleteShouldRemoveTransactions() {
            TransactionValidator validator = new TransactionValidator();
            TransactionRepository repository = new TransactionRepository(validator);
            Transaction transaction1 = new Transaction("1","1","1","56.78.1234","14",567,78,10);

            repository.add(transaction1);
            repository.delete(transaction1.getId());
            List<Transaction> allTransactions = repository.getAll();
            assertEquals(0, allTransactions.size());
            assertTrue(allTransactions.size() == 0);
        }

        @Test
        void getAllShouldGetAllTransactions() {
            TransactionValidator validator = new TransactionValidator();
            TransactionRepository repository = new TransactionRepository(validator);
            Transaction transaction3 = new Transaction("1","1","1","12.23.5678","15",567,78,10);
            Transaction transaction4 = new Transaction("1","1","1","23.56.7834","12",456,889,10);

            repository.add(transaction3);
            repository.add(transaction4);
            assertEquals(transaction3, repository.getAll().get(0));
            assertEquals(transaction4, repository.getAll().get(1));
            assertTrue(repository.getAll().size() == 2);
        }
    }

