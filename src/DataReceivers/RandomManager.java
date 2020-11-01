package DataReceivers;

import java.util.Random;

public class RandomManager {
    private Random random;

    public RandomManager() {
        this.random = new Random();
    }

    public String getNIP() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            sb.append(this.random.nextInt(9));
        }

        return sb.toString();
    }

    public String getDate(int startYear, int endYear) {
        int year = this.random.nextInt(endYear - startYear + 1) + startYear;

        int month = this.random.nextInt(12) + 1;

        int day = this.random.nextInt(28) + 1;

        return year + "-" + month + "-" + day;
    }
}
