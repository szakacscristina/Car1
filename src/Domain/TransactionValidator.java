
package Domain;

import Repository.IRepository;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;

    public class TransactionValidator implements IValidator<Transaction> {

        private IRepository<Car> carRepository;
        private IRepository<Client> clientRepository;

        public TransactionValidator(IRepository<Car> carRepository, IRepository<Client> clientRepository) {
            this.carRepository = carRepository;
            this.clientRepository = clientRepository;
        }

        public TransactionValidator() {

        }

        public void validate(Transaction transaction) {
            if (transaction.getPieceTotal() < 0) {
                throw new ValidatorException("The number of items must be at least 1.");
            }
        }
    }

