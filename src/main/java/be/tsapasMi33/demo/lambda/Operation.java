package be.tsapasMi33.demo.lambda;

@FunctionalInterface
public interface Operation<T> {
    T operate(T value1, T value2);
}
