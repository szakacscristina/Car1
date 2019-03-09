package Tests;

import Domain.Car;

import static org.junit.jupiter.api.Assertions.*;

class CarValidatorTest {

    @org.junit.jupiter.api.Test
    void getIdShouldReturnCorrectId(){

            Car car = new Car(1, "test", 1996, 100, 100, true);
            assertEquals(1, car.getId(), String.format("Returned %s, expected=%s", car.getId(), "1"));
            Car car2 = new Car(2, "test", 2002, 100, 100, true);
            assertEquals(2, car2.getId(), String.format("Returned %s, expected=%s", car.getId(), "2"));
        }

        @org.junit.jupiter.api.Test
        void setIdShouldSetTheGivenId() {
            Car car = new Car(1, "test", 1996, 100, 100, true);
            Integer setId = 7;
            car.setId(setId);
            assertEquals(setId, car.getId(), String.format("Returned=%s, Expected=%s", car.getId(), setId));
        }

        @org.junit.jupiter.api.Test
        void constructorShouldSetAllFieldsCorrectly() {
            Car car = new Car(1, "test", 1996, 100, 100, true);
            assertEquals(1, car.getId());
            assertEquals(1996, car.getModel());
            assertEquals(1996, car.getBoughtYear());
            assertEquals(100, car.getKilometers());
            assertEquals(100, car.getYearOffabrication());
            assertTrue(car.isInWarranty());
        }

        @org.junit.jupiter.api.Test
        void settersShouldSetFieldsCorrectly() {
            Car car = new Car(1, "test", 1996, 100, 100, true);

            car.setId(2);
            car.setModel("test2");
            car.setBoughtYear(2002);
            car.setKilometers(200);
            car.setYearOffabrication(200);
            car.setInWarranty(false);

            assertEquals(2, car.getId());
            assertEquals("test2", car.getModel());
            assertEquals("test2", car.getBoughtYear());
            assertEquals(200, car.getKilometers());
            assertEquals(200, car.getYearOffabrication());
            assertFalse(car.isInWarranty());
        }

        @org.junit.jupiter.api.Test
        void equalityShouldWorkCorrectly() {
            Car car1 = new Car(1, "test", 1996, 100, 100, true);
            Car car2 = new Car(1, "test", 1996, 100, 100, true);
            Car car3 = new Car(3, "test", 1996, 100, 100, true);

            assertNotEquals(car1, car3);
            assertNotEquals(car3, car1);
            assertNotEquals(car3, car2);
            assertNotEquals(car2, car3);
            assertEquals(car1, car2);
            assertEquals(car2, car1);
        }


        @org.junit.jupiter.api.Test
        void toStringShouldReturnALongEnoughString() {
            Car car1 = new Car(1, "test", 1996, 100, 100, true);

            assertTrue(car1.toString().length() > 10);
        }
    }
