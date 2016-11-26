package data;

import java.util.function.Consumer;

/**
 * Created by oTk on 24.11.2016.
 */
public interface Database<T> {
   // void save(Consumer<String> str);
    void save(String key, Object T);
    T read(String key);
    void delete(String key);
    T find(Object T);
    boolean isExist(String key);
}
