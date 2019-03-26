
    package Tests;

    import Domain.Car;
    import Domain.CarValidator;
    import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.*;

    public class CarValidatorTest{

        @Test
        public void validateCar() {
            CarValidator carV= new CarValidator();
            Car car = new Car("1","bmw","1225",1000,1234,true);
            carV.validate(car);
            assertDoesNotThrow(() -> carV.validate(car));

        }
    }



