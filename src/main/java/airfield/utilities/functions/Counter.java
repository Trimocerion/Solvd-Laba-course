package airfield.utilities.functions;

@FunctionalInterface
public interface Counter<T, R> {
    R run(T t1);
}
