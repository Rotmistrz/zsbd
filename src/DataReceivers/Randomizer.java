package DataReceivers;

import java.util.ArrayList;
import java.util.Random;

public class Randomizer<T> {
    private ArrayList<T> tokens;
    private Random random;
    private int tokensNumber;

    public Randomizer(ArrayList<T> list) {
        this.tokens = list;
        this.tokensNumber = this.tokens.size();

        this.random = new Random();
    }

    public int getTokensNumber() {
        return this.tokensNumber;
    }

    public T getToken() {
        int index = this.random.nextInt(this.getTokensNumber());

        return this.tokens.get(index);
    }

    public String getWords(int amount) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < amount; i++) {
            sb.append(this.getToken());
        }

        return sb.toString();
    }

    public String getMediumName() {
        int length = this.random.nextInt(4) + 2;

        return this.getWords(length);
    }
}
