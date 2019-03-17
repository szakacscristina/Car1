
    package Service;

import Domain.Car;
import Repository.CarRepository;

import java.util.List;

    public class CarService {

        private CarRepository repository;

        public CarService(CarRepository repository) {
            this.repository = repository;
        }

        /**
         *
         * @param id
         * @param model
         * @param boughtYear
         * @param kilometers
         * @param yearOffabrication
         * @param inWarranty
         */
        public void addOrUpdate(String id, String model, int boughtYear, double kilometers, int yearOffabrication, boolean inWarranty) {
            Car existing = repository.findById(id);
            if (existing != null) {
                // keep unchanged fields as they were
                if (model.isEmpty()) {
                    model = existing.getModel();
                }
                if (boughtYear == 0) {
                    boughtYear = existing.getBoughtYear();
                }
                if (kilometers == 0) {
                    kilometers = existing.getKilometers();
                }
                if (yearOffabrication == 0) {
                    yearOffabrication = existing.getYearOffabrication();
                }
            }
            Car car = new Car(id, model, boughtYear, kilometers, yearOffabrication, inWarranty);
            repository.upsert(car);
        }

        /**
         *
         * @param id
         */
        public void remove(String id) {
            repository.remove(id);
        }

        /**
         *
         * @return
         */

        public List<Car> getAll() {
            return repository.getAll();
        }


        public List <Car> getCars() {return repository.getAll();}


    }


