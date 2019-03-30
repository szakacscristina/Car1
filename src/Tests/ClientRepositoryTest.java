package Tests;

import Domain.Client;
import Domain.ClientValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientRepositoryTest {

    @Test
    void getByIdShouldReturnCorrectTransaction() {
        ClientValidator validator = new ClientValidator();
        ClientRepository repository = new ClientRepository(validator);
        Client client1 = new Client("1", "ugf", "hjgyuk", "1234567891234", "10.10.2010", "12.12.2012");

        repository.upsert(client1);
        Client clientToFind = repository.findById("1");
        assertNotNull(clientToFind, "Return not <null> for existing id");
        assertEquals(clientToFind.getId(), 1, String.format("Return id %s instead of correct id=1", clientToFind.getId()));
        assertEquals(clientToFind.getLastName(), "TestFirst", String.format("Return name %s instead of correct name=TestFirst", clientToFind.getLastName()));
        assertEquals(clientToFind.getFirstName(), "TestFirst", String.format("Return first name %s instead of correct firstName=TestFirst", clientToFind.getFirstName()));
        assertEquals(clientToFind.getCNP(), "1234567891234", String.format("Return CNP %s instead of correct CNP=1234567891234", clientToFind.getCNP()));
        assertEquals(clientToFind.getDateOfBirth(), "10.10.2010", String.format("Return date of birth %s instead of correct dateOfBirth=10.10.2010", clientToFind.getDateOfBirth()));
        assertEquals(clientToFind.getDateOfRegistration(), "12.12.2012", String.format("Return date of birth %s instead of correct dateOfRegistration=12.12.2012", clientToFind.getDateOfBirth()));
    }



    @Test
    void removeShouldRemoveClients() {
        ClientValidator validator = new ClientValidator();
        ClientRepository repository = new ClientRepository(validator);
        Client client1 = new Client("1", "uief", "uhf", "1234567891234", "12.12.2012", "10.10.2020");
        Client client2 = new Client("2", "iudegd", "udyief", "1234567891234", "12.12.2012", "10.10.2020");

        repository.upsert(client1);
        repository.upsert(client2);
        repository.remove(client1.getId());
        repository.remove(client2.getId());
        assertEquals(0, repository.getAll().size());
        assertFalse(repository.getAll().size() != 0);
    }

    @Test
    void getAll() {
        ClientValidator validator = new ClientValidator();
        ClientRepository repository = new ClientRepository(validator);
        Client client1 = new Client("1", "uief", "uhf", "1234567891234", "12.12.2012", "10.10.2020");
        Client client2 = new Client("2", "iudegd", "udyief", "1234567891234", "12.12.2012", "10.10.2020");

        repository.upsert(client1);
        repository.upsert(client2);
        assertEquals(client1, repository.getAll().get(0));
        assertEquals(client2, repository.getAll().get(1));
        assertTrue(repository.getAll().size() == 2);
    }
}



