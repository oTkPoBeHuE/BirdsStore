package data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oTk on 24.11.2016.
 */
public class MemoryDatabase<T> implements Database<T> {
    private Map <String, T> data = new HashMap<>();

    @Override
    public void save(String key, T value) {
        data.put(key.toLowerCase(), value);
    }

    @Override
    public T read(String key) {
        return data.get(key.toLowerCase());
    }

    @Override
    public void delete(String key) {
        data.remove(key.toLowerCase());
    }

    @Override
    public boolean containsKey(String key) {
        return data.containsKey(key.toLowerCase());
    }
}
