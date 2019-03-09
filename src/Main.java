import Domain.Car;
import Domain.CarValidator;
import Repository.CarRepository;
import Service.CarService;
import UI.Console;

public class Main {

    public static void main(String[] args) {
        CarValidator carValidator = new CarValidator();


        CarRepository carRepository = new CarRepository(carValidator);


        CarService carService = new CarService(carRepository);


        Console console = new Console(carService);
        console.run();
    }
}
