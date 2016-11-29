package data;

import java.util.List;

public interface Database<T> {
    void save(String key, T value);
    T find(String key);
    void delete(String key);
    List<T> findAll();

    boolean containsKey(String key);
    int size();
    void clear();
}
