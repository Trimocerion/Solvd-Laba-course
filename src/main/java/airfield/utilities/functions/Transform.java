package airfield.utilities.functions;

@FunctionalInterface
public interface Transform<T, R>{
    R run(T t);
}