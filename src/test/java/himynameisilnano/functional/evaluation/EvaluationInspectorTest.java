package himynameisilnano.functional.evaluation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

final class EvaluationInspectorTest {

    @Test
    void slow_task_is_executed_10_times() {
        List<Integer> list = IntStream.rangeClosed(1, 10)
                .filter(EvaluationInspector::SlowAndLessSelectiveTask)
                .filter(EvaluationInspector::QuickAndHighlySelectiveTask)
                .mapToObj(value -> value * 2)
                .toList();

        Assertions.assertEquals(List.of(12, 16, 20), list);
    }

    /**
     * This case shows that it is a good idea to put the most selective filter on top of the chain and that
     * precedence should be given to the fastest filters first
     */
    @Test
    void slow_task_is_executed_5_times() {
        List<Integer> list = IntStream.rangeClosed(1, 10)
                .filter(EvaluationInspector::QuickAndHighlySelectiveTask)
                .filter(EvaluationInspector::SlowAndLessSelectiveTask)
                .mapToObj(value -> value * 2)
                .toList();

        Assertions.assertEquals(List.of(12, 16, 20), list);
    }
}