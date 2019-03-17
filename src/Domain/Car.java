
    package Domain;

import java.util.Objects;

    public class Car {
        private String id;
        private String model;
        private int boughtYear ;
        private double kilometers;
        private int yearOffabrication;
        private boolean inWarranty;

        public Car(String id, String model, int boughtYear, double kilometers, int yearOffabrication, boolean inWarranty) {
            this.id = id;
            this.model = model;
            this.boughtYear = boughtYear;
            this.kilometers = kilometers;
            this.yearOffabrication = yearOffabrication;
            this.inWarranty = inWarranty;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Car car = (Car) o;
            return id == car.id &&
                    boughtYear == car.boughtYear &&
                    Double.compare(car.kilometers, kilometers) == 0 &&
                    yearOffabrication == car.yearOffabrication &&
                    inWarranty == car.inWarranty &&
                    Objects.equals(model, car.model);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, model, boughtYear, kilometers, yearOffabrication, inWarranty);
        }

        @Override
        public String toString() {
            return "Car{" +
                    "id=" + id +
                    ", model='" + model + '\'' +
                    ", boughtYear=" + boughtYear +
                    ", kilometers=" + kilometers +
                    ", yearOffabrication=" + yearOffabrication +
                    ", inWarranty=" + inWarranty +
                    '}';
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getBoughtYear() {
            return boughtYear;
        }

        public void setBoughtYear(int boughtYear) {
            this.boughtYear = boughtYear;
        }

        public double getKilometers() {
            return kilometers;
        }

        public void setKilometers(double kilometers) {
            this.kilometers = kilometers;
        }

        public int getYearOffabrication() {
            return yearOffabrication;
        }

        public void setYearOffabrication(int yearOffabrication) {
            this.yearOffabrication = yearOffabrication;
        }

        public boolean isInWarranty() {
            return inWarranty;
        }

        public void setInWarranty(boolean inWarranty) {
            this.inWarranty = inWarranty;
        }

    }



