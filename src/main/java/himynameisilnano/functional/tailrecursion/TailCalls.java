package himynameisilnano.functional.tailrecursion;

public final class TailCalls {

    public static <T> TailCall<T> call(TailCall<T> nextCall) {
        System.out.println("call -> nextCall");
        return nextCall;
    }

    public static <T> TailCall<T> done(T value) {
        return new TailCall<>() {
            @Override
            public boolean isComplete() {
                System.out.println("done -> isComplete");
                return true;
            }

            @Override
            public T result() {
                System.out.println("done -> value");
                return value;
            }

            @Override
            public TailCall<T> apply() {
                throw new Error("Not implemented");
            }
        };
    }
}
