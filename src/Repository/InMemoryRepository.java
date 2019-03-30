
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

    public T getById(int id){
        return repository.get(id);
    }

    public void insert(T entity){
        if (repository.containsKey(entity.getId())){
            throw new DuplicateEntityException("ERROR: An entity with that ID already exists!");
        } else{
            validator.validate(entity);
            repository.put(entity.getId(), entity);
        }
    }

    public void update(T entity){
        if (!repository.containsKey(entity.getId())){
            throw new RuntimeException("ERROR: There is no entity with that ID!");
        } else{
            validator.validate(entity);
            repository.put(entity.getId(), entity);
        }
    }

    public void remove(int id){
        if (!repository.containsKey(id)){
            throw new RuntimeException("ERROR: There is no entity with that ID");
        } else {
            repository.remove(id);
        }
    }

    @Override
    public T findById(String id) {
        return null;
    }

    @Override
    public void addorUpdate(T car) {

    }

    @Override
    public void remove(String id) {

    }

    public ArrayList<T> getAll(){
        return new ArrayList<>(repository.values());
    }
}