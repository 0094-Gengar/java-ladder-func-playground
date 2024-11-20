package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderRowGenerator {
    private static RandomGenerator randomGenerator;

    public LadderRowGenerator(RandomGenerator randomGenerator) {
        LadderRowGenerator.randomGenerator = randomGenerator;
    }

    public static List<String> generateLadderRow(int widthOfLadder) {
        List<String> ladderRow = new ArrayList<>();
        ladderRow.add("|");

        boolean previousBridgeExists = false;

        for (int i = 0; i < widthOfLadder - 1; i++) {
            if (!previousBridgeExists && randomGenerator.generateRandom() == 1) {
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
