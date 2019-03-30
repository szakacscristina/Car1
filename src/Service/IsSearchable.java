package Service;

import Domain.Entity;
import java.util.ArrayList;

public abstract class IsSearchable<T extends Entity> {

    /*
     * This abstract class will provide the logic for searching entities by field
     * CarService and ClientService will inherit this class and use its search method
     * */

    public void fullTextSearch(String[] terms, ArrayList<T> entities) {
        for (String term : terms) {
            for (T entity : entities) {
                ArrayList<String> fields = entity.getSearchableFields();
                for (String field : fields) {
                    if (term.toLowerCase().equals(field.toLowerCase())) {
                        System.out.println(entity.toString());
                    }
                }
            }
        }
    }
}