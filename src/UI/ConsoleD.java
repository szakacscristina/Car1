package UI;
import Domain.Car;
import Domain.Client;
import Domain.Transaction;
import Service.ClientService;
import Service.CarService;
import Service.TransactionService;
import java.util.Scanner;

public class ConsoleD {

        private ClientService clientService;
        private CarService carService;
        private TransactionService transactionService;
        private Scanner scanner;

        public ConsoleD(CarService carService, ClientService clientService, TransactionService transactionService) {
            this.clientService = clientService;
            this.carService = carService;
            this.transactionService = transactionService;

            this.scanner = new Scanner(System.in);
        }
        public void run() {
            System.out.println("Write requirement (type EXIT to finish)");
            System.out.println("Options: Add/Update | Remove | Show");
            System.out.println("Obs: Add Car(id, model,boughtYear,kilometers, yearOffabrication,inWarranty)");
            System.out.println("Obs: Add Client(id, lastName, firstName, CNP, dateOfBirth (dd.mm.yyyy), dateOfRegistration(dd.mm.yyyy)");
            System.out.println("Obs: Add Transaction (id, idCar, idClientCard, date(dd.mm.yyyy), time, pieceTotal, workmanship, discount)");
            System.out.println("Obs: Remove(id)");
            String r = scanner.nextLine();
            do {
                interpretRequirements(r);
                r = scanner.nextLine();
            } while (!r.toLowerCase().contains("exit"));
        }

        public void interpretRequirements(String requirement) {
            String[] option = requirement.split(",");
            if (option[0].toLowerCase().contains("car")) {
                if (option[0].equalsIgnoreCase("addcar")) {
                    handleAddUpdateCar((option[1]), option[2],option[3], Double.parseDouble(option[4]), Integer.parseInt(option[5]), Boolean.parseBoolean(option[6]));
                }
                if (option[0].equalsIgnoreCase("removecar")) {
                    handleRemoveCar(option[1]);
                }
                if (option[0].equalsIgnoreCase("showcar")) {
                    handleViewCars();
                }
            }

            if (option[0].toLowerCase().contains("client")) {
                if (option[0].equalsIgnoreCase("addclient")) {
                    handleAddUpdateClient(option[1], option[2], option[3], option[4], option[5], option[6]);
            }
                if (option[0].equalsIgnoreCase("removeclient")) {
                    handleRemoveClient(option[1]);
                }
                if (option[0].equalsIgnoreCase("showclient")) {
                    handleViewClients();
                }
            }

            if (option[0].toLowerCase().contains("transaction")) {
                if (option[0].equalsIgnoreCase("addtransaction")) {


                    handleAddUpdateTransaction(option[1],option[2], option[3], option[4], option[5], Double.parseDouble(option[6]));
                }
                if (option[0].equalsIgnoreCase("removetransaction")) {
                    handleRemoveTransaction(option[1]);
                }
                if (option[0].equalsIgnoreCase("showtransaction")) {
                    handleViewTransactions();
                }
            }
        }

        private void handleViewCars() {
            for (Car car : carService.getCars()) {
                System.out.println(car);
            }
        }

        private void handleRemoveCar(String id) {
            try {
                carService.remove(id);

                System.out.println("Car removed!");
            } catch (Exception ex) {
                System.out.println("Errors:\n" + ex.getMessage());
            }
        }

        private void handleAddUpdateCar(String id, String model, String boughtYear, double kilometers, int yearOffabrication, boolean inWarranty){
            try {
                carService.addOrUpdate(id, model, boughtYear, kilometers, yearOffabrication, inWarranty);
                System.out.println("Product added!");
            } catch (Exception ex) {
                System.out.println("Errors:\n" + ex.getMessage());
            }
        }

        private void handleViewClients() {
            for (Client client : clientService.getClients()) {
                System.out.println(client);
            }
        }

        private void handleRemoveClient(String id) {
            try {
                clientService.remove(id);
                System.out.println("Client info removed!");
            } catch (Exception ex) {
                System.out.println("Errors:\n" + ex.getMessage());
            }
        }

        private void handleAddUpdateClient(String id, String lastName, String firstName, String CNP, String dateOfBirth,String dateOfRegistration) {
            try {
                clientService.addOrUpdate(id, lastName, firstName, CNP, dateOfBirth, dateOfRegistration);
                System.out.println("Client added!");
            } catch (Exception ex) {
                System.out.println("Errors:\n" + ex.getMessage());
            }
        }

        private void handleViewTransactions() {
            for (Transaction transaction : transactionService.getAllTransactions()) {
                System.out.println(transaction);
            }
        }

        private void handleRemoveTransaction(String id) {
            try {
                transactionService.remove(id);

                System.out.println("Transaction removed!");
            } catch (Exception ex) {
                System.out.println("Errors:\n" + ex.getMessage());
            }
}

        private void handleAddUpdateTransaction(String id,String idCar, String idClientCard, String date, String time, double pieceTotal) {
            try {
                Transaction transaction = transactionService.addOrUpdate(id, idCar, idClientCard, pieceTotal, date, time);
                System.out.println(String.format("Added transaction id=%s,paid price=%f, discount=%f%%", transaction.getId(),transaction.getPieceTotal(), transaction.getDiscount()));
            } catch (Exception ex) {
                System.out.println("Errors:\n" + ex.getMessage());
            }
        }
    }

