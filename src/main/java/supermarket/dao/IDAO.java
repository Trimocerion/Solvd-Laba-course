package supermarket.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDAO<T>{
     T get(long id) throws SQLException;
     long save(T t);
     void update(T t);
     void delete(T t);
     List<T> getAll();
}