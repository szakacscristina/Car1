
    package Domain;

import java.util.Objects;
import java.util.ArrayList;

    public class Transaction extends Entity  {

        private String id, idCar, idClientCard, date, time;
        private double pieceTotal;
        private double workmanshipTotal;
        private double discount;

        public Transaction(String id, String idCar, String idClientCard, String date, String time, double pieceTotal, double workmanshipTotal, double discount) {
            super(id);
            this.idCar = idCar;
            this.idClientCard = idClientCard;
            this.date = date;
            this.time = time;
            this.pieceTotal = pieceTotal;
            this.workmanshipTotal = workmanshipTotal;
            this.discount = discount;
        }


        /**
         * Custom getter for the discounted price.
         * @return the price after applying the discount.
         */
        public double getDiscountedPrice() {
            return workmanshipTotal*pieceTotal - discount * workmanshipTotal*pieceTotal;
        }
        @Override
        public String toString() {
            return "Transaction{" +
                    "id='" + id + '\'' +
                    ", idCar='" + idCar + '\'' +
                    ", idClientCard='" + idClientCard + '\'' +
                    ", pieceTotal='" + pieceTotal + '\'' +
                    ", date='" + date + '\'' +
                    ", time='" + time + '\'' +
                    ", workmanshipTotal=" + workmanshipTotal +
                    ", discount=" + discount +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Transaction that = (Transaction) o;
            return Objects.equals(id, that.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, idCar, idClientCard, pieceTotal, date, time, workmanshipTotal, discount);
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getIdCar() {
            return idCar;
        }

        public void setIdCar(String idCar) {
            this.idCar = idCar;
        }

        public String getIdClientCard() {
            return idClientCard;
        }

        public void setIdClientCard(String idClientCard) {
            this.idClientCard = idClientCard;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public double getPieceTotal() {
            return pieceTotal;
        }

        public void setPieceTotal(double pieceTotal) {
            this.pieceTotal = pieceTotal;
        }

        public void setWorkmanshipTotal(double workmanshipTotal) {
            this.workmanshipTotal = workmanshipTotal;
        }
        public double getWorkmanshipTotal() {
            return workmanshipTotal;
        }

        public double getDiscount() {
            return discount;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }

        public ArrayList<String> getSearchableFields(){
            return new ArrayList<>();
        }
    }

