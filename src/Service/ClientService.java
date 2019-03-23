package Service;

import Domain.Car;
import Domain.Client;
import Repository.CarRepository;
import Repository.ClientRepository;

import java.util.List;

public class ClientService {

    private ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    /**
     *
     * @param id
     * @param lastName
     * @param firstName
     * @param CNP
     * @param dateOfBirth
     * @param dateOfRegistration
     */
    public void addOrUpdate(String id, String lastName, String firstName, String CNP, String dateOfBirth, String dateOfRegistration) {
        Client existing = repository.findById(id);
        if (existing != null) {
            // keep unchanged fields as they were
            if (lastName.isEmpty()) {
                lastName = existing.getLastName();
            }
            if (firstName.isEmpty()) {
                firstName = existing.getFirstName();
            }
            if (CNP.isEmpty()) {
                CNP = existing.getCNP();
            }
            if (dateOfBirth.isEmpty()) {
                dateOfBirth = existing.getDateOfBirth();
            }
            if (dateOfRegistration.isEmpty()) {
                dateOfRegistration = existing.getDateOfRegistration();
            }
            List<Client> CNPcheck= repository.show();
            for (Client c: CNPcheck){
                if (c.getCNP().equals(CNP)){
                    throw new RuntimeException("error: existent CNP");
                }
            }
        }
        Client client = new Client(id, lastName, firstName, CNP, dateOfBirth, dateOfRegistration);
        repository.upsert(client);
    }

    /**
     *
     * @param id
     */
    public void remove(String id) {
        repository.remove(id);
    }

    /**
     *
     * @return
     */
    public List<Client> getAll() {
        return repository.getAll();
    }

    public List<Client> getClients(){ return repository.getAll();}
}
