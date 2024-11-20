package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderRowGenerator {
    private static RandomGenerator randomGenerator = new RandomGenerator();

    public LadderRowGenerator(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public static List<String> generateLadderRow(int widthOfLadder) {
        List<String> ladderRow = new ArrayList<>();
        ladderRow.add("|");

        boolean previousBridgeExists = false;
        int value = randomGenerator.generateRandom();
        for (int i = 0; i < widthOfLadder - 1; i++) {
            if (!previousBridgeExists && value == 1) {
                ladderRow.add("-----");
                previousBridgeExists = true;
            } else {
                ladderRow.add("     ");
                previousBridgeExists = false;
            }
            ladderRow.add("|");
        }
        return ladderRow;
    }
}
