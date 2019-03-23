package Tests;

import Domain.Car;
import Domain.CarValidator;
import Repository.CarRepository;
import Service.CarService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {

    @Test
    void addOrUpdateServiceShouldAddCar() {
        CarValidator validator = new CarValidator();
        CarRepository repository = new CarRepository(validator);
        CarService carService = new CarService(repository);
        Car car = new Car("1","bmw",1356,1000,1234,true);

        carService.addOrUpdate("1","bmw",1356,10000,1234,true);
        assertEquals(car,carService.getAll().get(0));
        assertEquals(2, carService.getAll().size());
    }


    @Test
    void removeServiceShouldRemoveCar() {
        CarValidator validator = new CarValidator();
        CarRepository repository = new CarRepository(validator);
        CarService carService = new CarService(repository);
        Car car = new Car("1","bmw",6743,10000,8764,true);

        carService.addOrUpdate("1","bmw",6743,10000,8764,true);
        carService.remove("1");
        assertEquals(0, carService.getAll().size());
        assertFalse(carService.getAll().size() != 0);
    }

    @Test
    void getAllServiceShouldGetAllMedicine() {
        CarValidator validator = new CarValidator();
        CarRepository repository = new CarRepository(validator);
        CarService medicineService = new CarService(repository);
        Car car1 = new Car("1","bmw",6534,100000,8734,true);
        Car car2 = new Car("2","mercedes",6534,10000,8723,true);

        medicineService.addOrUpdate("1", "bmw", 7634, 10000, 3656, false);
        medicineService.addOrUpdate("2", "mercedes", 6723, 160000, 7634, true);
        assertEquals(car1, medicineService.getAll().get(0));
        assertEquals(car2, medicineService.getAll().get(1));
        assertFalse(medicineService.getAll().size() != 2);
    }
}

