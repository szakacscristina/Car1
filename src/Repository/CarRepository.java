package Repository;

import Domain.Car;
import Domain.CarValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    public class CarRepository {
        private Map<String, Car> storage = new HashMap<>();
        private CarValidator validator;

        /**
         *
         * @param carValidator
         */
        public CarRepository(CarValidator carValidator) {
            this.validator = carValidator;
        }

        /**
         *
         * @param id
         * @return
         */
        public Car getById(String id) {
            return storage.get(id);
        }
        /**
         *

         * @param car
         */
        public void insert(Car car) {
            if (storage.containsKey(car.getId())) {
                throw new RuntimeException(String.format("There already is a cake with id=%s", car.getId()));
            }

            validator.validate(car);
            storage.put(car.getId(), car);
        }

        /**
         *
         * @param car
         */
        public void update(Car car) {
            if (!storage.containsKey(car.getId())) {
                throw new RuntimeException(String.format("There is no cake with id=%s", car.getId()));
            }

            validator.validate(car);
            storage.put(car.getId(), car);
        }

        /**
         *
         * @param id
         */
        public void remove(String id) {
            if (!storage.containsKey(id)) {
                throw new RuntimeException(String.format("There is no car with id=%s", id));
            }

            storage.remove(id);
        }

        /**
         *
         * @return
         */
        public List<Car> getAll() {
            return new ArrayList<>(storage.values());
        }
    }


