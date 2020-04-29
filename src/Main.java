import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static long minutesPassed(long start) {
        long ms = System.currentTimeMillis() - start;

        return ms / 1000 / 60;
    }

    public static void main(String[] args) {
        int minutes = Integer.parseInt(args[0]);
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            output.append("a");
        }

        int threads = 8;
        long start = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(threads);
        for (int i = 0; i < threads; i++) {
            int thread = i + 1;
            executor.submit(() -> {
                while (minutesPassed(start) < minutes) {
                    System.err.println("Thread " + thread + " says: ");
                    System.err.println(output);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
                System.out.println("Logging thread " + thread + " exited");
            });
        }

        while (minutesPassed(start) < minutes) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
