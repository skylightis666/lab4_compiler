import java.util.Random;

public class Generator {
    String generate(int length) {
        int count_ab = length / 2 - 1;
        Random random = new Random();
        String generatedLine;
        StringBuilder s = new StringBuilder();
        if (length == 1) {
            s.append("b");
        } else {
            s.append("a");
            if (count_ab > 0) {
                int rand_ab = random.nextInt(count_ab) + 1;
                if (count_ab - rand_ab > rand_ab) {
                    rand_ab = count_ab - rand_ab;
                }
                s.append("ab".repeat(rand_ab));
                s.append("ac");
                s.append("cb".repeat(Math.max(0, count_ab - rand_ab)));
            } else {
                s.append("ac");
            }

        }
        generatedLine = s.toString();
        return generatedLine;
    }
}