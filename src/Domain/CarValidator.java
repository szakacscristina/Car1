package Domain;

public class CarValidator {

    public void validate(Car car) {

        String errors = "";
        if (car.getKilometers() <= 0) {
            errors += "The kilometers must be > 0!\n";
        }
        if (car.getYearOffabrication() <= 0) {
            errors += "The yearOffabrication must be > 0!\n";
        }

        if (!errors.isEmpty()) {
            throw new ValidatorException(errors);
        }
    }
}


