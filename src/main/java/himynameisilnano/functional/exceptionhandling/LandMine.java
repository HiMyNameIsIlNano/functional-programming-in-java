package himynameisilnano.functional.exceptionhandling;

import java.util.concurrent.Callable;

public class LandMine<T> {

    private final Callable<T> task;

    public LandMine(Callable<T> task) {
        this.task = task;
    }

    public Try<T> unload() {
        try {
            return Try.of(task.call());
        } catch (Exception e) {
            return Try.failure(new RuntimeException(e));
        }
    }

}
