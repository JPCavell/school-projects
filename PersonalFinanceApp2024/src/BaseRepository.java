
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BaseRepository<T extends IEntity> implements IRepository<T> {

    Map<String, T> entities = new HashMap<>();

    @Override
    public boolean Add(T value) {

        if (isValidName(value.getName())) {

            entities.put(value.getName(), value);
            return true;
        } else {
            return false;
        }

    }

    private boolean isValidName(String name) {

        if (entities.containsKey(name)) {
            return false;
        }

        if (name == null) {
            return false;
        }
        return true;

    }

    public boolean updateName(String oldName, String newName) {

        if (isValidName(newName)) {
            T e = entities.get(oldName);
            if (e != null) {
                e.setName(newName);
                entities.remove(oldName);
                entities.put(newName, e);
                return true;
            } 
        }
        else {
                return false;

        }

        return false;
    }

    @Override
    public T getByName(String name) {
        return entities.get(name);
    }

    public Collection<T> getAll() {
        return Collections.unmodifiableCollection(entities.values());
    }

    public boolean remove(String name) {
        if (entities.containsKey(name)) {
            entities.remove(name);
            return true;
        }
        return false;

    }

}
