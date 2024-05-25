package himynameisilnano.functional.tailrecursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialTest {

    @Test
    void factorial() {
        assertEquals(120, Factorial.factorial(5));
    }
}