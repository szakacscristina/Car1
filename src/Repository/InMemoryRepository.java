
package Repository;

import Domain.Entity;
import Domain.IValidator;

import java.util.ArrayList;
import java.util.HashMap;

public class InMemoryRepository<T extends Entity> implements IRepository<T> {

    private HashMap<String, T> repository = new HashMap<>();
    private IValidator<T> validator;

    public InMemoryRepository(IValidator<T> validator){
        this.validator = validator;
    }

    public T findById(String id){
        return repository.get(id);
    }

    public void upsert(T entity){
            validator.validate(entity);
            repository.put(entity.getId(), entity);
        }
    public void remove(String id){
        if (!repository.containsKey(id)){
            throw new ValidatorExceptionRepository("ERROR: There is no entity with that ID");
        } else {
            repository.remove(id);
        }
    }

    public ArrayList<T> getAll(){
        return new ArrayList<>(repository.values());
    }
}