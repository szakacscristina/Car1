
    package Tests;

import Domain.Client;

import static org.junit.jupiter.api.Assertions.*;


    class ClientTest {

        @org.junit.jupiter.api.Test
        void getIdShouldReturnCorrectId() {
            Client client = new Client("1", "test", "test1", "123456789116", "24.04.1994", "23.05.2002");
            assertEquals("1", client.getId(), String.format("Returned %s, expected=%s", client.getId(), "1"));
            Client client2 = new Client("2", "test", "test2", "123456789113", "12.03.2005", "06.02.2005");
            assertEquals("2", client2.getId(), String.format("Returned %s, expected=%s", client.getId(), "2"));
        }

        @org.junit.jupiter.api.Test
        void setIdShouldSetTheGivenId() {
            Client client = new Client("1", "test", "test2", "123456789126", "23.06.1995", "19.10.1998");
            String setId = "7";
            client.setId(setId);
            assertEquals(setId, client.getId(), String.format("Returned=%s, Expected=%s", client.getId(), setId));
        }

        @org.junit.jupiter.api.Test
        void constructorShouldSetAllFieldsCorrectly() {
            Client client = new Client("1", "test", "test2", "123456778954", "23.06.1995", "13.07.1998");
            assertEquals("1", client.getId());
            assertEquals("test", client.getLastName());
            assertEquals("test2", client.getFirstName());
            assertEquals("123456789126", client.getCNP());
            assertEquals("23.06.1995", client.getDateOfBirth());
            assertEquals("13.07.1998", client.getDateOfRegistration());

        }

        @org.junit.jupiter.api.Test
        void settersShouldSetFieldsCorrectly() {
            Client client = new Client("1", "test", "test2", "123445678954", "23.96.1756", "12.95.1567");

            client.setId("2");
            client.setLastName("test");
            client.setFirstName("test2");
            client.setCNP("123445678954");
            client.setDateOfBirth("23.96.1756");
            client.setDateOfBirth("12.95.1567");

            assertEquals("2", client.getId());
            assertEquals("test3", client.getLastName());
            assertEquals("test2", client.getFirstName());
            assertEquals("123445678954", client.getCNP());
            assertEquals("23.96.1756", client.getDateOfBirth());
            assertEquals("12.95.1567", client.getDateOfRegistration());


        }

        @org.junit.jupiter.api.Test
        void equalityShouldWorkCorrectly() {
            Client client1 = new Client("1", "test", "test2", "100", "12.85.1345", "56.84.5673");
            Client client2 = new Client("1", "test", "test2", "200", "67.94.2467", "76.95.1234");
            Client client3 = new Client ("3", "test", "test3", "300", "76.94.2345", "76.84.2568");

            assertNotEquals(client1, client3);
            assertNotEquals(client3, client1);
            assertNotEquals(client3, client2);
            assertNotEquals(client2, client3);
            assertEquals(client1, client2);
            assertEquals(client2, client1);
        }


        @org.junit.jupiter.api.Test
        void toStringShouldReturnALongEnoughString() {
            Client client1 = new Client("1", "test", "test2", "12345678926", "12.85.1345", "56.84.5673");

            assertTrue(client1.toString().length() > 10);
        }
    }





