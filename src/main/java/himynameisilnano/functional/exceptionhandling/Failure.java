package himynameisilnano.functional.exceptionhandling;

public record Failure(Throwable error) implements Try<String> {

    @Override
    public String data() {
        return error.getLocalizedMessage();
    }
}
