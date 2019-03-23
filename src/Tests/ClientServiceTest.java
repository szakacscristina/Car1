package Tests;

import Domain.Client;
import Domain.ClientValidator;
import Repository.ClientRepository;
import Service.ClientService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientServiceTest {

    @Test
    void addOrUpdateServiceShouldAddClients() {
        ClientValidator validator = new ClientValidator();
        ClientRepository repository = new ClientRepository(validator);
        ClientService clientService = new ClientService(repository);
        Client client1 = new Client("1","ana","sara","1234567890123","12.34.5678","34.56.4567");
        Client client2 = new Client("2","hfuef","yguy","1234564789543","12.56.3456","56.34.1234");

        clientService.addOrUpdate("1", "TestFirst", "TestFirst", "1234567891234", "12.12.2012", "10.10.2020");
        clientService.addOrUpdate("2", "TestSecond", "TestSecond", "1234567891234", "12.12.2012", "10.10.2020");
        assertEquals(client1, clientService.getAll().get(0));
        assertEquals(client2, clientService.getAll().get(1));
        assertEquals(2, clientService.getAll().size());
    }



    @Test
    void removeServiceShouldRemoveClient() {
        ClientValidator validator = new ClientValidator();
        ClientRepository repository = new ClientRepository(validator);
        ClientService clientService = new ClientService(repository);
        Client client1 = new Client("1","ana","sara","1234567890123","12.34.5678","34.56.4567");
        Client client2 = new Client("2","hfuef","yguy","1234564789543","12.56.3456","56.34.1234");


        clientService.addOrUpdate("1", "TestFirst", "TestFirst", "1234567891234", "12.12.2012", "10.10.2020");
        clientService.addOrUpdate("2", "TestSecond", "TestSecond", "1234567891234", "12.12.2012", "10.10.2020");
        clientService.remove("1");
        clientService.remove(client2.getId());
        assertEquals(0, clientService.getAll().size());
        assertFalse(clientService.getAll().size() != 0);
    }

    @Test
    void getAllServiceShouldShowAllClients() {
        ClientValidator validator = new ClientValidator();
        ClientRepository repository = new ClientRepository(validator);
        ClientService clientService = new ClientService(repository);
        Client client1 = new Client("1","ana","sara","1234567890123","12.34.5678","34.56.4567");
        Client client2 = new Client("2","hfuef","yguy","1234564789543","12.56.3456","56.34.1234");

        clientService.addOrUpdate("1", "TestFirst", "TestFirst", "1234567891234", "12.12.2012", "10.10.2020");
        clientService.addOrUpdate("2", "TestSecond", "TestSecond", "1234567891234", "12.12.2012", "10.10.2020");
        assertEquals(client1, clientService.getAll().get(0));
        assertEquals(client2, clientService.getAll().get(1));
        assertTrue(clientService.getAll().size() == 2);
    }
}