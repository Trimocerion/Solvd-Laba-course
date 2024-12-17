package airfield.utilities.functions;

@FunctionalInterface
public interface TransformFunction<T, R>{
    R run(T t);
}