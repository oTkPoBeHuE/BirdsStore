package data;

import java.util.List;
import java.util.function.Consumer;

/**
 * Created by oTk on 24.11.2016.
 */
public interface Database<T> {
    void  save(String key, T value);   //TODO: rename
    T read(String key);
    void delete(String key);
    boolean containsKey(String key);
    int size();
    List<T> toList();
}
