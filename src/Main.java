import Domain.CarValidator;
import Domain.ClientValidator;
import Tests.TransactionValidator;
import Repository.CarRepository;
import Repository.ClientRepository;
import Repository.TransactionRepository;
import Service.CarService;
import Service.ClientService;
import Service.TransactionService;
import UI.Console;

public class Main {

    public static void main(String[] args) {

        CarValidator carValidator = new CarValidator();
        ClientValidator clientValidator = new ClientValidator();
        TransactionValidator transactionValidator = new TransactionValidator();

        CarRepository carRepository = new CarRepository(carValidator);
        ClientRepository clientRepository = new ClientRepository(clientValidator);
        TransactionRepository transactionRepository = new TransactionRepository(transactionValidator);

        CarService carService = new CarService(carRepository);
        ClientService clientService = new ClientService(clientRepository);
        TransactionService transactionService = new TransactionService(transactionRepository, carRepository);

        Console console = new Console(carService, clientService, transactionService);
        console.run();

        /**ConsoleD doi = new ConsoleD(carService, clientService, transactionService);
        doi.run();**/

    }
}
