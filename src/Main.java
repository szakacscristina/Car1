import Domain.*;
import Domain.ClientValidator;
import Domain.IValidator;
import Domain.CarValidator;
import Domain.TransactionValidator;
import Repository.IRepository;
import Repository.InMemoryRepository;
import Service.ClientService;
import Service.CarService;
import Service.TransactionService;
import UI.MainController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/MainWindow.fxml"));
        Parent root = fxmlLoader.load();

        IValidator<Car> carValidator = new CarValidator();
        IValidator<Client> clientValidator = new ClientValidator();
        IValidator<Transaction> transactionValidator = new TransactionValidator();

        IRepository<Car> carRepository = new InMemoryRepository<>(carValidator);
        IRepository<Client> clientRepository = new InMemoryRepository<>(clientValidator);
        IRepository<Transaction> transactionRepository = new InMemoryRepository<>(transactionValidator);

        CarService carService = new CarService(carRepository);
        carService.addOrUpdate("1","bmw","1234", 10000, 1076, false );
        carService.addOrUpdate("2","mercedes","8645", 273573, 6515, true );
        carService.addOrUpdate("3","logan","5753", 39485648, 6517, false );

        ClientService clientService = new ClientService(clientRepository);
        clientService.addOrUpdate("1", "Cristina", "A", "1234567891234", "12.10.2010", "12.12.2019");
        clientService.addOrUpdate("2", "Maria", "B", "2234567891234", "13.10.2010", "12.13.2019");
        clientService.addOrUpdate("3", "Ioana", "C", "3234567891234", "14.10.2010", "12.14.2019");

        TransactionService transactionService = new TransactionService(transactionRepository);
        transactionService.addOrUpdate("1", "11", "13", 5, "12.12.2012","10:00");
        transactionService.addOrUpdate("2", "21", "24", 15, "12.12.2012","12:00");
        transactionService.addOrUpdate("3", "6", "7", 25, "12.12.2012","10:00");

        MainController mainController = fxmlLoader.getController();
        mainController.setServices(carService, clientService, transactionService);

        primaryStage.setTitle("Car manager");
        primaryStage.setScene(new Scene(root, 600, 475));
        primaryStage.show();

    }

    public static void main(String[] args){
        launch(args);
    }
}

