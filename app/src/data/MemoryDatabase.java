package data;

import java.util.*;


public class MemoryDatabase<T> implements Database<T> {
    private Map <String, T> data = new HashMap<>();

    @Override
    public void save(String key, T value) {
        data.put(key.toLowerCase(), value);
    }

    @Override
    public T find(String key) {
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

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<T>(data.values());
    }

    @Override
    public void clear() {
        data.clear();
    }
}
