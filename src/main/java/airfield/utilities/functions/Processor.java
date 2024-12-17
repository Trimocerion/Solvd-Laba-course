package airfield.utilities.functions;

@FunctionalInterface
public interface Processor<T, R> {
    R run(T t1);
}
