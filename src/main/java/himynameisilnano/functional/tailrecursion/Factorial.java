package himynameisilnano.functional.tailrecursion;

import static himynameisilnano.functional.tailrecursion.TailCalls.call;
import static himynameisilnano.functional.tailrecursion.TailCalls.done;

public final class Factorial {

    private static TailCall<Integer> factorial(final int factorial, final int number) {
        if (number == 1) {

            return done(factorial);
        }

        return call(() -> factorial(factorial * number, number - 1));
    }

    public static Integer factorial(int number) {
        return factorial(1, number).invoke();
    }
}
