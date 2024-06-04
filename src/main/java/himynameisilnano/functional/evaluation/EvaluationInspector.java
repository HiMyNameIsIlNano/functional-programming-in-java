package himynameisilnano.functional.evaluation;

public class EvaluationInspector {

    public boolean slowIsNumberEven(int data) {
        try {
            Thread.sleep(100L);
            System.out.println("Slow Task: " + data);
            return data % 2 == 0;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean quickIsGreaterThan(int data, int threshold) {
        System.out.println("Quick Task: " + data);

        return data > threshold;
    }

}
