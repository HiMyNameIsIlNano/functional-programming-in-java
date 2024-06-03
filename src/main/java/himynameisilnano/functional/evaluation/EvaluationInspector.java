package himynameisilnano.functional.evaluation;

public class EvaluationInspector {

    public static boolean SlowAndLessSelectiveTask(int data) {
        try {
            Thread.sleep(100L);
            System.out.println("Slow Task: " + data);
            return data % 2 == 0;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean QuickAndHighlySelectiveTask(int data) {
        System.out.println("Quick Task: " + data);

        return data > 5;
    }

}
