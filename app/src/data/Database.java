package data;

import java.util.function.Consumer;

/**
 * Created by oTk on 24.11.2016.
 */
public interface Database<T> {
    void  save(String key, T value);
    T read(String key);
    void delete(String key);
    boolean ontainsKey(String key);
}
