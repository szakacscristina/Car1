package Service;

import Domain.Transaction;
import Domain.Car;
import Repository.IRepository;

import java.util.List;


public class TransactionService {

    private IRepository<Transaction> repository;
    private IRepository<Car> carRepository;

    public TransactionService(IRepository<Transaction> repository, IRepository<Car> carRepository){
        this.repository = repository;
        this.carRepository = carRepository;
    }

    public TransactionService(TransactionRepository repository) {
    }

    public double getPaidPrice(String idCar, double pieceTotal, String idClientCard){
        // determine the price paid for this transaction
        List<Car> cars = carRepository.getAll();

        for (Car car : cars){
            if (car.getId() == idCar){
                double initialPrice = car.getKilometers() * pieceTotal;
                if (idClientCard != null){
                    if (car.isInWarranty()) return initialPrice - (10.00/100 * initialPrice);
                    else return initialPrice - (10.00/100 * initialPrice);
                } else return initialPrice;
            }
        }
        throw new ValidatorExceptionService("Wrong Car ID ERROR: Found no Car for this transaction.");
    }


    /**
     * @param id
     * @param idCar
     * @param idClientCard
     * @param pieceTotal
     * @param date
     * @param time
     * @return
     */
    public Transaction addOrUpdate(String id, String idCar, String idClientCard, double pieceTotal, String date, String time) {
        Transaction existing = repository.findById(id);
        if (existing != null) {
            // keep unchanged fields as they were
            if (idCar.isEmpty()) {
                idCar = existing.getIdCar();
            }
            if (idClientCard.isEmpty()) {
                idClientCard = existing.getIdClientCard();
            }
            if (pieceTotal == 0) {
                pieceTotal = existing.getPieceTotal();
            }
            if (date.isEmpty()) {
                date = existing.getDate();
            }
            if (time.isEmpty()) {
                time = existing.getTime();
            }
        }

        Car carSold = carRepository.findById(idCar);
        if (carSold == null) {
            throw new ValidatorExceptionService("There is no car with the given id!");
        }
        double workmanshipTotal = carSold.getYearOffabrication();
        double discount = 0;
        if (idClientCard != null) {
            workmanshipTotal = 0.1; // 10% discount

            if (carSold.isInWarranty()) {
                pieceTotal = 0; // piesele sunt gratis
            }

            Transaction transaction = new Transaction(id, idCar, idClientCard, date, time, pieceTotal, workmanshipTotal, discount);
            repository.upsert(transaction);
            return transaction;
        }


        return existing;
    }

    /**
     *
     * @param id
     */
    public void remove (String id){
        repository.remove(id);
    }

    /**
     *
     * @return
     */
    public List<Transaction> getAll () {
        return repository.getAll();
    }

    public List<Transaction> getAllTransactions(){return repository.getAll();}


}