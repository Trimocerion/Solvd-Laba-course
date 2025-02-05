package supermarket.service;

import java.util.List;

public interface IService<T> {
    T get(long id);
    long save(T t);
    void update(T t);
    void delete(T t);
    List<T> getAll();
}
