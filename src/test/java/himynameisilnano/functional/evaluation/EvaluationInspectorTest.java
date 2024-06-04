package himynameisilnano.functional.evaluation;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

final class EvaluationInspectorTest {

    @Test
    void slow_task_is_executed_10_times() {
        // Arrange
        EvaluationInspector testSubject = mock(EvaluationInspector.class);

        when(testSubject.quickIsGreaterThan(anyInt(), eq(5))).thenCallRealMethod();
        when(testSubject.slowIsNumberEven(anyInt())).thenCallRealMethod();

        // Act
        var list = IntStream.rangeClosed(1, 10)
                .filter(testSubject::slowIsNumberEven)
                .filter(data -> testSubject.quickIsGreaterThan(data, 5))
                .mapToObj(value -> value * 2)
                .toList();

        // Assert
        assertEquals(List.of(12, 16, 20), list);
        verify(testSubject, times(10)).slowIsNumberEven(anyInt());
        verify(testSubject, times(5)).quickIsGreaterThan(anyInt(), eq(5));
    }

    /**
     * This case shows that it is a good idea to put the most selective filter on top of the chain and that
     * precedence should be given to the fastest filters first
     */
    @Test
    void slow_task_is_executed_5_times() {
        // Arrange
        EvaluationInspector testSubject = mock(EvaluationInspector.class);

        when(testSubject.quickIsGreaterThan(anyInt(), eq(5))).thenCallRealMethod();
        when(testSubject.slowIsNumberEven(anyInt())).thenCallRealMethod();

        // Act
        var list = IntStream.rangeClosed(1, 10)
                .filter(data -> testSubject.quickIsGreaterThan(data, 5))
                .filter(testSubject::slowIsNumberEven)
                .mapToObj(value -> value * 2)
                .toList();

        // Assert
        assertEquals(List.of(12, 16, 20), list);
        verify(testSubject, times(5)).slowIsNumberEven(anyInt());
        verify(testSubject, times(10)).quickIsGreaterThan(anyInt(), eq(5));
    }
}