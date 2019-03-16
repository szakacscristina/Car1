package Service;

import Domain.Car;
import Domain.Transaction;
import Repository.CarRepository;
import Repository.TransactionRepository;

import java.util.List;


public class TransactionService {

    private TransactionRepository transactionRepository;
    private CarRepository carRepository;

    public TransactionService(TransactionRepository transactionRepository, CarRepository carRepository) {
        this.transactionRepository = transactionRepository;
        this.carRepository = carRepository;
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
        Transaction existing = transactionRepository.findById(id);
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
            throw new RuntimeException("There is no car with the given id!");
        }
        double workmanshipTotal = carSold.getYearOffabrication();
        double discount = 0;
        if (idClientCard != null) {
            workmanshipTotal = 0.1; // 10% discount

            if (carSold.isInWarranty()) {
                pieceTotal = 0; // piesele sunt gratis
            }

            Transaction transaction = new Transaction(id, idCar, idClientCard, date, time, pieceTotal, workmanshipTotal, discount);
            transactionRepository.upsert(transaction);
            return transaction;
        }


        return existing;
    }

    /**
     *
     * @param id
     */
    public void remove (String id){
        transactionRepository.remove(id);
    }

    /**
     *
     * @return
     */
    public List<Transaction> getAll () {
        return transactionRepository.getAll();
    }
}