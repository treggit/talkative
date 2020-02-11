public class Main {

    public static long minutesPassed(long start) {
        long ms = System.currentTimeMillis() - start;

        return ms / 1000 / 60;
    }

    public static void main(String[] args) {
        int minutes = Integer.parseInt(args[0]);
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 4 * 90000; i++) {
            output.append("a");
        }

        long start = System.currentTimeMillis();
        while (minutesPassed(start) < minutes) {
            System.err.println(output);
        }
    }
}
