package himynameisilnano.functional.exceptionhandling;

public interface Try<T> {

    static <T> Try<T> of(T value) {
        return new Success<>(value);
    }

    static Try failure(Exception value) {
        return new Failure(value);
    }

    default T data() {
        throw new UnsupportedOperationException("Not implemented");
    }

    default Throwable error() {
        throw new UnsupportedOperationException("Not implemented");
    }

}
