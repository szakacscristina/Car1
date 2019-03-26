package UI;

import Domain.Car;
import Domain.Client;
import Domain.Transaction;
import Service.CarService;
import Service.ClientService;
import Service.TransactionService;

import java.util.Scanner;

public class Console {

    private CarService carService;
    private ClientService clientService;
    private TransactionService transactionService;

    private Scanner scanner;

    public Console(CarService carService, ClientService clientService, TransactionService transactionService){
        this.carService = carService;
        this.clientService = clientService;
        this.transactionService = transactionService;

        this.scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. Car CRUD");
        System.out.println("2. Client CRUD");
        System.out.println("3. Transaction CRUD");
        System.out.println("4. ICarUpdate CRUD");
        System.out.println("x. Exit");
    }

    public void run() {
        while (true) {
            showMenu();

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    runCarCrud();
                    break;
                case "2":
                    runClientCrud();
                    break;
                case "3":
                   runTransactionCrud();
                    break;
                case "x":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

   private void runTransactionCrud() {
        while (true) {
            System.out.println("1. Add or update a transaction");
            System.out.println("2. Remove a transaction");
            System.out.println("3. View all transactions");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateTransaction();
                    break;
                case "2":
                    handleRemoveTransaction();
                    break;
                case "3":
                    handleViewTransactions();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleViewTransactions() {
        for (Transaction transaction : transactionService.getAll()) {
            System.out.println(transaction);
        }
    }

    private void handleRemoveTransaction() {
        try {
            System.out.print("Enter the id to remove:");
            String id = scanner.nextLine();
            transactionService.remove(id);

            System.out.println("Transaction removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateTransaction() {
        try {
            System.out.print("Enter id: ");
            String id = scanner.nextLine();
            System.out.print("Enter car id (empty to not change for update): ");
            String idCar = scanner.nextLine();
            System.out.print("Enter client card (empty to not change for update): ");
            String idClientCard = scanner.nextLine();
            System.out.print("Enter piece total (0 to not change for update): ");
            double pieceTotal = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter date (empty to not change for update): ");
            String date = scanner.nextLine();
            System.out.print("Enter time (empty to not change for update): ");
            String time = scanner.nextLine();

            Transaction transaction = transactionService.addOrUpdate(id, idCar, idClientCard, pieceTotal, date, time);
            System.out.println(String.format("Added transaction id=%s, paid price=%f, discount=%f%%", transaction.getId(), transaction.getDiscountedPrice(), transaction.getDiscount()));
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void runClientCrud() {
        while (true) {
            System.out.println("1. Add or update a client");
            System.out.println("2. Remove a client");
            System.out.println("3. View all clients");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateClient();
                    break;
                case "2":
                    handleRemoveClient();
                    break;
                case "3":
                    handleViewClients();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleViewClients() {
        for (Client client : clientService.getAll()) {
            System.out.println(client);
        }
    }

    private void handleRemoveClient() {
        try {
            System.out.print("Enter the id to remove:");
            String id = scanner.nextLine();
            clientService.remove(id);

            System.out.println("Client removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateClient() {
        try {
            System.out.print("Enter id: ");
            String id = scanner.nextLine();
            System.out.print("Enter last name (empty to not change for update): ");
            String lastName = scanner.nextLine();
            System.out.print("Enter first name (empty to not change for update): ");
            String firstName = scanner.nextLine();
            System.out.print("Enter CNP (empty to not change for update): ");
            String CNP = scanner.nextLine();
            System.out.print("Enter date of birth (empty to not change for update): ");
            String dateOfBirth = scanner.nextLine();
            System.out.print("Enter date of registration (empty to not change for update): ");
            String dateOfRegistration = scanner.nextLine();

            clientService.addOrUpdate(id, lastName, firstName, CNP, dateOfBirth, dateOfRegistration);

            System.out.println("Client added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void runCarCrud() {
        while (true) {
            System.out.println("2. Remove a car");
            System.out.println("1. Add or update a car");
            System.out.println("3. View all cars");
            System.out.println("4. Back");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    handleAddUpdateCar();
                    break;
                case "2":
                    handleRemoveCar();
                    break;
                case "3":
                    handleViewCars();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    private void handleViewCars() {
        for (Car car : carService.getAll()) {
            System.out.println(car);
        }
    }

    private void handleRemoveCar() {
        try {
            System.out.print("Enter the id to remove:");
            String id = scanner.nextLine();
            carService.remove(id);

            System.out.println("Car removed!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    private void handleAddUpdateCar() {

        try {
            System.out.print("Enter id: ");
            String id = scanner.nextLine();
            System.out.print("Enter model (empty to not change for update): ");
            String model = scanner.nextLine();
            System.out.print("Enter bought year (empty to not change for update): ");
            String  boughtYear = scanner.nextLine();
            System.out.print("Enter kilometers (0 to not change for update): ");
            double kilometers = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter year of fabrication (0 to not change for update): ");
            int yearOfFabrication = Integer.parseInt (scanner.nextLine());
            System.out.print("Enter warranty (true / false): ");
            boolean inWarranty = Boolean.parseBoolean(scanner.nextLine());

            carService.addOrUpdate(id, model, boughtYear, kilometers, yearOfFabrication, inWarranty);

            System.out.println("Car added!");
        } catch (Exception ex) {
            System.out.println("Errors:\n" + ex.getMessage());
        }
    }

    }

