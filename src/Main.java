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
        long messagesSize = Long.parseLong(args[1]);
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < messagesSize; i++) {
            output.append("a");
        }

        int threads = Integer.parseInt(args[2]);
        long delay = Long.parseLong(args[3]);
        long start = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(threads);
        for (int i = 0; i < threads; i++) {
            int thread = i + 1;
            executor.submit(() -> {
                while (minutesPassed(start) < minutes / 2) {
                    System.err.println("Thread " + thread + " says: ");
                    System.err.println(output);
                    try {
                        Thread.sleep(delay);
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

        executor.shutdownNow();
    }
}
