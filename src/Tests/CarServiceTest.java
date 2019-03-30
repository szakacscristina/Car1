package Tests;

import Domain.Car;
import Domain.CarValidator;
import Repository.CarRepository;
import Service.CarService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {

    @Test
    void addOrUpdateServiceShouldAddCar() {
        CarValidator validator = new CarValidator();
        CarRepository repository = new CarRepository(validator);
        CarService carService = new CarService(repository);
        Car car = new Car("1","bmw","1356",1000,1234,true);

        carService.addOrUpdate("1","bmw","1356",1000,1234,true);
        assertEquals(car,carService.getAll().get(1));
        assertEquals(1, carService.getAll().size());
    }


    @Test
    void removeServiceShouldRemoveCar() {
        CarValidator validator = new CarValidator();
        CarRepository repository = new CarRepository(validator);
        CarService carService = new CarService(repository);
        Car car = new Car("1","bmw","6743",10000,8764,true);

        carService.addOrUpdate("1","bmw","6743",10000,8764,true);
        carService.remove("1");
        assertEquals(0, carService.getAll().size());
        assertFalse(carService.getAll().size() != 0);
    }

    @Test
    void getAllServiceShouldGetAllCars() {
        CarValidator validator = new CarValidator();
        CarRepository repository = new CarRepository(validator);
        CarService carService = new CarService(repository);
        Car car1 = new Car("1","bmw","6534",10000,8734,true);
        Car car2 = new Car("2","mercedes","6534",10000,8723,true);

        carService.addOrUpdate("1", "bmw", "6534", 10000, 8734, true);
        carService.addOrUpdate("2", "mercedes", "6534", 10000, 8723, true);
        assertEquals(car1, carService.getAll().get(1));
        assertEquals(car2, carService.getAll().get(2));
        assertFalse(carService.getAll().size() != 2);
    }
}

