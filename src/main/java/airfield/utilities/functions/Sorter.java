package airfield.utilities.functions;

@FunctionalInterface
public interface Sorter<T> {
    int compare(T t1, T t2);
}
