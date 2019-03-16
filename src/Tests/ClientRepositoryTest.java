package Tests;

import Domain.Client;
import Domain.ClientValidator;
import Repository.ClientRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

    class ClientRepositoryTest {

        @Test
        void insertShouldAddCakes() {
            ClientValidator validator = new ClientValidator();
            ClientRepository repository = new ClientRepository(validator);
            Client client1 = new Client("1","2","3","100","45.87.6745","56.95.3456");
            Client client2 = new Client("2","2","3","100","67.95.1234","56.85.3865");
            Client client1Dupe = new Client("1","2","3","100","76.84.6534","96.84.6345");

            repository.upsert(client1);
            List<Client> all = repository.getAll();
            assertEquals(1, all.size());
            assertEquals(client1, all.get(0));

            try {
                repository.upsert(client1Dupe);
                fail("Exception not thrown for duplicate client id!");
            } catch (RuntimeException rex) {
                assertTrue(true);
            }
        }

        @Test
        void update() {
        }
    }



