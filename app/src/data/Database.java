package data;

import java.util.List;
import java.util.function.Consumer;

/**
 * Created by oTk on 24.11.2016.
 */
public interface Database<T> {
    void save(String key, T value);
    T find(String key);
    void delete(String key);
    List<T> findAll();


    boolean containsKey(String key);
    int size();
    void clear();
}
