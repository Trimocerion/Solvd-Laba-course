package supermarket.dao;

import java.util.List;

public interface IDAO<T>{
     T get(long id);
     void save(T t);
     void update(T t);
     void delete(T t);
     List<T> getAll();
}