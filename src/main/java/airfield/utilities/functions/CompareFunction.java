package airfield.utilities.functions;

@FunctionalInterface
public interface CompareFunction<T> {
    int compare(T t1, T t2);
}
