package Domain;

import java.util.ArrayList;
import java.util.Objects;

public abstract class Entity {

    private String id;

    public Entity(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return id == entity.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public abstract String toString();

    public String getId(){
        return this.id;
    }

    public void setId(String id){
        this.id = id;
    }

    public abstract ArrayList<String> getSearchableFields();

}