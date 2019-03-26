
package Repository;

import Domain.Entity;
import java.util.ArrayList;

public interface IRepository<T extends Entity> {

    public T findById(String id);

    public void upsert(T entity);

    public void remove(String id);

    public ArrayList<T> getAll();
}


