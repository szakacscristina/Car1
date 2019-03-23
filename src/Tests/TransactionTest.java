package Tests;

import Domain.Transaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    void equalsShouldCompareTheTransactionCorectly() {
        Transaction transaction1 = new Transaction("1","1","1","45.67.1234","10",234,567,10);
        Transaction transaction2 = new Transaction("2","2","2","45.78.1234","14",456,567,10);
        Transaction transaction3 = new Transaction("3","3","3","45.67.1234","15",567,67,10);

        assertEquals(transaction1, transaction2);
        assertEquals(transaction2, transaction1);
        assertNotEquals(transaction1, transaction3);
        assertNotEquals(transaction3, transaction1);
        assertNotEquals(transaction2, transaction3);
        assertNotEquals(transaction3, transaction2);
    }
    @Test
    void constructorShouldSetAllTheFildsCorectly(){
        Transaction transaction1 = new Transaction("1","1","1","45.78.1234","15",565,78,10);

        assertEquals(1, transaction1.getId());
        assertEquals(1, transaction1.getIdClientCard());
        assertEquals(1,transaction1.getIdClientCard());
        assertEquals(5, transaction1.getPieceTotal());
        assertEquals("12.12.2012", transaction1.getDate());
        assertEquals("10:00", transaction1.getTime());
    }

    @Test
    void settersShouldSetFieldsCorrectly() {
        Transaction transaction1 = new Transaction("1","1","1","34.56.3456","14",45,67,10);

        transaction1.setId("1");
        transaction1.setIdClientCard("1");
        transaction1.setIdClientCard("1");
        transaction1.setPieceTotal(5);
        transaction1.setDate("12.12.2012");
        transaction1.setTime("12:00");

        assertEquals(1, transaction1.getId());
        assertEquals(1, transaction1.getIdClientCard());
        assertEquals(1,transaction1.getIdClientCard());
        assertEquals(5, transaction1.getPieceTotal());
        assertEquals("12.12.2012", transaction1.getDate());
        assertEquals("12:00", transaction1.getTime());
    }

    @Test
    void toStringShouldReturnALongEnoughString() {
        Transaction transaction = new Transaction("1","1","1","12.45.1234","14",456,345,10);

        assertTrue(transaction.toString().length() > 10);
    }
}