
    package Tests;


    import Domain.Client;
    import Domain.ClientValidator;
    import org.junit.jupiter.api.Test;

    import static org.junit.jupiter.api.Assertions.*;

    public class ClientValidatorTest {

        @Test
        void validateErrorsShouldNotThrowExceptions() {
            ClientValidator clientV= new ClientValidator();
            Client client= new Client("1","ana","sara","1234567890123","12.45.6789","45.67.1234");
            Client client1= new Client("2","hf","hygd","1864523451245","12.45.6789","56.78.1234");
            clientV.validate(client);
            assertDoesNotThrow(() -> clientV.validate(client));
            assertDoesNotThrow(() -> clientV.validate(client1));
        }

    }



