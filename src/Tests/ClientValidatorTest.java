
    package Tests;

    import Domain.Client;
    import Domain.ClientValidator;
    import org.junit.jupiter.api.Test;

    import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

    public class ClientValidatorTest {

        @Test
        public void validateClient() {
            ClientValidator clientV= new ClientValidator();
            Client client= new Client("1","ana","sofia","1234567891234","15.12.2012","12.12.2012");
            clientV.validate(client);
            assertDoesNotThrow(() -> clientV.validate(client));
        }
    }



