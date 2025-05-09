package L5_CustomFunctionalInterfaces;
import java.util.Objects;
import java.util.function.Function;

public class q29_TriFunction {
    @FunctionalInterface
    public interface TriFunction<T, U, V, R> {
        R apply(T t, U u, V v);

        default <K> TriFunction<T, U, V, K> andThen(Function<? super R, ? extends K> after) {
            Objects.requireNonNull(after);
            return (T t, U u, V v) -> after.apply(apply(t, u, v));
        }
    }

    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> multiplyThenAdd = (x, y, z) -> x * y + z;

        int result = multiplyThenAdd.apply(2, 3, 4);
        System.out.println("Result: " + result);

        TriFunction<Integer, Integer, Integer, Integer> finalResult = multiplyThenAdd.andThen(r -> r * 2);
        System.out.println("Final Result: " + finalResult.apply(2, 3, 4));
    }
}

