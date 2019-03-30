package Tests;

import Domain.Car;
import Domain.CarValidator;
import Repository.CarRepository;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class CarRepositoryTest {

    @Test
    void findByIdWithExistingIdShouldReturnCorrectCar() {

        CarValidator validator = new CarValidator();
        CarRepository repository = new CarRepository(validator);
        Car addedCar = new Car("1","bmw","1234",10000,5674,true);

        repository.upsert(addedCar);
        Car existingCar = repository.findById("1");
        assertNotNull(existingCar, "Returned null for existing id!");
        assertEquals(existingCar.getId(), 1, String.format("Returned id %s instead of correct id=1!", existingCar.getId()));
        assertEquals(existingCar.getModel(), "Test", String.format("Returned model instead of %s", existingCar.getModel(), addedCar.getModel()));
        assertEquals(existingCar.getBoughtYear(), "Test", String.format("Returned bought year instead of %s ", existingCar.getBoughtYear(), addedCar.getBoughtYear()));
        assertEquals(existingCar.getKilometers(), "Test", String.format("Returned kilometers instead of %s", existingCar.getKilometers(), addedCar.getKilometers()));
        assertEquals(existingCar.getYearOffabrication(), 100, String.format("Returned year of fabrication %s instead of price=100", existingCar.getYearOffabrication(), addedCar.getYearOffabrication()));
        assertEquals(existingCar.isInWarranty(), true, String.format("Returned warranty instead of %s", existingCar.isInWarranty(), addedCar.isInWarranty()));
    }



    @Test
    void removeShouldRemoveCars() {
        CarValidator validator = new CarValidator();
        CarRepository repository = new CarRepository(validator);
        Car car1 = new Car("1","bmw","6534",100000,6534,true);

        repository.upsert(car1);
        repository.remove(car1.getId());
        List<Car> allMedicines = repository.getAll();
        assertEquals(0, allMedicines.size());
        assertFalse(repository.getAll().size() != 0);
    }

    @Test
    void getAllShouldGetAllCars() {
        CarValidator validator = new CarValidator();
        CarRepository repository = new CarRepository(validator);
        Car car1 = new Car("1","bmw","6534",100000,8734,true);
        Car car2 = new Car("2","mercedes","6534",10000,8723,true);

        repository.upsert(car1);
        repository.upsert(car2);
        List<Car> allCars = repository.getAll();
        assertEquals(car1, allCars.get(0));
        assertEquals(car2, allCars.get(1));
        assertFalse(repository.getAll().size() != 2);
    }
}
