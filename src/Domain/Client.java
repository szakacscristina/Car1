
    package Domain;

import java.util.Objects;

    public class Client {

        private String id, lastName, firstName, CNP, dateOfBirth, dateOfRegistration;

        public Client(String id, String lastName, String firstName, String CNP, String dateOfBirth, String dateOfRegistration) {
            this.id = id;
            this.lastName = lastName;
            this.firstName = firstName;
            this.CNP = CNP;
            this.dateOfBirth = dateOfBirth;
            this.dateOfRegistration = dateOfRegistration;
        }

        @Override
        public String toString() {
            return "Client{" +
                    "id='" + id + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", CNP='" + CNP + '\'' +
                    ", dateOfBirth='" + dateOfBirth + '\'' +
                    ", dateOfRegistration='" + dateOfRegistration + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Client client = (Client) o;
            return Objects.equals(id, client.id);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, lastName, firstName, CNP, dateOfBirth, dateOfRegistration);
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getCNP() {
            return CNP;
        }

        public void setCNP(String CNP) {
            this.CNP = CNP;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getDateOfRegistration() {
            return dateOfRegistration;
        }

        public void setDateOfRegistration(String dateOfRegistration) {
            this.dateOfRegistration = dateOfRegistration;
        }
    }



