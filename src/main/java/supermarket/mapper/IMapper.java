package supermarket.mapper;

import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface IMapper<T> {
    T get(@Param("id") long id);
    long save(T entity);
    void update(T entity);
    void delete(@Param("id") long id);
    List<T> getAll();
}
