package Tests;

import Domain.Car;
import Domain.CarValidator;
import Repository.CarRepository;
import org.junit.jupiter.api.Test;

import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

    class CarRepositoryTest {

        @Test
        void insertShouldAddCakes() {
            CarValidator validator = new CarValidator();
            CarRepository repository = new CarRepository(validator);
            Car car1 = new Car("1","2",2004,100,100,true);
            Car car2 = new Car("2","2",2005,100,100,true);
            Car car1Dupe = new Car("1","2",2006,100,100,true);

            repository.insert(car1);
            List<Car> all = repository.getAll();
            assertEquals(1, all.size());
            assertEquals(car1, all.get(0));

            try {
                repository.insert(car1Dupe);
                fail("Exception not thrown for duplicate car id!");
            } catch (RuntimeException rex) {
                assertTrue(true);
            }
        }

        @Test
        void update() {
        }
    }

