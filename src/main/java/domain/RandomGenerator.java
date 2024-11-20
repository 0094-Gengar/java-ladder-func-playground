package domain;

import java.util.Random;

public class RandomGenerator {
    private static final Random random = new Random();

    public int generateRandom() {
        return random.nextInt(2);
    }
}
