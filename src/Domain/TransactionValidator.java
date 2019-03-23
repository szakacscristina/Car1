
    package Domain;

    public class TransactionValidator {

        public void validate(Transaction transaction) {
            if (transaction.getPieceTotal() < 0) {
                throw new ValidatorException("The number of items must be at least 1.");
            }
        }
    }

