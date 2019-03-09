package UI;

import Domain.Car;
import Service.CarService;

import java.util.Scanner;

    public class Console {
        private CarService carService;
        private Scanner scanner;

        public Console(CarService carService) {
            this.carService = carService;
            this.scanner = new Scanner(System.in);
        }

        public void run() {
            while (true) {
                showMenu();

                String option = scanner.nextLine();
                switch (option) {
                    case "1":
                        runCars();
                        break;
                    case "2":
                        //runClients();
                        break;
                    case "3":
                        //runTransactions();
                        break;
                    case "x":
                        return;
                    default:
                        System.out.println("Optiune invalida!");
                        break;
                }
            }
        }

        private void runCars() {
            while (true) {
                showCarsMenu();
                String option = scanner.nextLine();
                switch (option) {
                    case "1":
                        handleAddCar();
                        break;
                    case "2":
                        handleUpdateCar();
                        break;
                    case "3":
                        handleRemoveCar();
                        break;
                    case "4":
                        handleShowAllCars();
                        break;
                    case "x":
                        return;
                    default:
                        System.out.println("Optiune invalida!");
                }
            }
        }

        private void handleShowAllCars() {
            for (Car car : carService.getAll()) {
                System.out.println(car);
            }
        }

        private void handleRemoveCar() {
            try {
                System.out.print("Enter id to remove: ");
                Integer id = Integer.valueOf(scanner.nextLine());

                carService.remove(id);

                System.out.println("Car removed successfully!");
            } catch (RuntimeException rex) {
                System.out.println("Errors:\n" + rex.getMessage());
            }
        }

        private void handleUpdateCar() {
            try {
                System.out.print("Enter id to update: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter new model: ");
                String model = scanner.nextLine();
                System.out.print("Enter new bought year: ");
                int boughtYear = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter new number of kilometers: ");
                double kilometers = Double.parseDouble(scanner.nextLine());
                System.out.print("Enter new yearOffabrication: ");
                int yearOffabrication = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter new warranty (true/false): ");
                boolean inWarranty = Boolean.parseBoolean(scanner.nextLine());

                carService.update(id, model, boughtYear, kilometers, yearOffabrication, inWarranty);

                System.out.println("Car updated successfully!");
            } catch (RuntimeException rex) {
                System.out.println("Errors:\n" + rex.getMessage());
            }
        }

        private void handleAddCar() {
            try {
                System.out.print("Enter id: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter model: ");
                String model = scanner.nextLine();
                System.out.print("Enter bought year: ");
                int boughtYear = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter number of kilometers: ");
                double kilometers = Double.parseDouble(scanner.nextLine());
                System.out.print("Enter year of fabrication: ");
                int yearOffabrication = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter warranty (true/false): ");
                boolean inWarranty = Boolean.parseBoolean(scanner.nextLine());

                carService.insert(id, model, boughtYear, kilometers, yearOffabrication, inWarranty);

                System.out.println("Car added successfully!");
            } catch (RuntimeException rex) {
                System.out.println("Errors:\n" + rex.getMessage());
            }
        }

        private void showCarsMenu() {
            System.out.println("1. Add car");
            System.out.println("2. Update car");
            System.out.println("3. Remove car");
            System.out.println("4. Show all");
            System.out.println("x. Back");
        }

        private void showMenu() {
            System.out.println("1. CRUD Cars");
            System.out.println("2. CRUD Clients");
            System.out.println("3. CRUD Transactions");
            System.out.println("x. Exit");
        }
    }


