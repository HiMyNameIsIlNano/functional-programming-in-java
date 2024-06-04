package himynameisilnano.functional.exceptionhandling;

public record Success<T>(T data) implements Try<T> {
}
