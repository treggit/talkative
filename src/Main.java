public class Main {

    public static long minutesPassed(long start) {
        long ms = System.currentTimeMillis() - start;

        return ms / 1000 / 60;
    }

    public static void main(String[] args) {
        int minutes = Integer.parseInt(args[0]);
        long start = System.currentTimeMillis();
        while (minutesPassed(start) < minutes) {
            System.err.println("As build log can grow very large, let's ensure agent memory consumption is reasonably limited and build log is not stored in memory in its fullness. Caching it on disk will help.\n" +
                    "\n" +
                    "With this not fixed, agent can encounter outOfMemory error is the build log does not fit in memory and server goes offline");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
