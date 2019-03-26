
package Domain;

import java.text.SimpleDateFormat;
import java.text.ParseException;

public class ClientValidator implements IValidator<Client> {
    /*
     * represents validator class for a Client object
     *
     * */
    public void validate(Client card){
        String errors = "";

        if (card.getCNP().length() < 13){
            errors += "CNP has too few characters!\n";
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
        // validate birth date
        try {
            dateFormat.parse(card.getDateOfBirth());
        } catch (ParseException pe){
            errors += pe.getMessage() + "\n";
        }
        // validate enrollment date
        try {
            dateFormat.parse(card.getDateOfRegistration());
        } catch (ParseException pe){
            errors += pe.getMessage() + "\n";
        }

        if (!errors.isEmpty()){
            throw new RuntimeException(errors);
        }
    }
}

