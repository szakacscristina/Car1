package Repository;

import Domain.Car;
import Domain.CarValidator;
import Domain.Client;
import Domain.ClientValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientRepository {

    private Map<String, Client> storage = new HashMap<>();
    private ClientValidator validator;

    public ClientRepository(ClientValidator validator) {
        this.validator = validator;
    }

    public Client findById(String id) {
        return storage.get(id);
    }

    /**
     * Adds or updates a client if it already exists.
     * @param client the client to add or update.
     */
    public void upsert(Client client) {
        validator.validate(client);
        storage.put(client.getId(), client);
    }

    /**
     * Removes a client with a given id.
     * @param id the id.
     * @throws RuntimeException if there is no client with the given id.
     */
    public void remove(String id) {
        if (!storage.containsKey(id)) {
            throw new RuntimeException("There is no client with the given id to remove.");
        }

        storage.remove(id);
    }

    public List<Client> getAll() {
        return new ArrayList<>(storage.values());
    }
}
