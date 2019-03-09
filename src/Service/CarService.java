package Service;

import Domain.Car;
import Repository.CarRepository;

import java.util.List;

    public class CarService {
        private CarRepository repository;

        public CarService(CarRepository repository) {
            this.repository = repository;
        }

        public void insert(int id, String model, int boughtYear, double kilometers, int yearOffabrication, boolean inWaranty) {
            Car car = new Car(id, model, boughtYear, kilometers, yearOffabrication, inWaranty);
            repository.insert(car);
        }

        public void update(int id, String model, int boughtYear, double kilometers, int yearOffabrication, boolean inWaranty) {
            Car car = new Car(id, model, boughtYear, kilometers, yearOffabrication, inWaranty);
            repository.update(car);
        }

        public void remove(Integer id) {
            repository.remove(id);
        }

        public List<Car> getAll() {
            return repository.getAll();
        }
    }


