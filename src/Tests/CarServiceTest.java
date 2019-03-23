package Tests;

import Domain.Car;
import Domain.CarValidator;
import Repository.CarRepository;
import Service.CarService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MedicineServiceTest {

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
    }
}