package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private static RandomGenerator randomGenerator = new RandomGenerator();

    public Ladder(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;
    }

    public static List<String> generateLadderRow(int widthOfLadder) {
        List<String> ladderRow = new ArrayList<>();
        ladderRow.add("|");

        boolean previousBridgeExists = false;
        int widthCount = 1;

        for (int i = 0; ; i++) {
            int randomValue = randomGenerator.generateRandom();

            // 직전에 연결 다리가 없는 경우 - 1) 연결 다리 생성
            if (!previousBridgeExists && randomValue == 1) {
                ladderRow.add("-----");
                previousBridgeExists = true;
                ladderRow.add("|");
                widthCount++;
            }
            if (widthCount == widthOfLadder) {
                break;
            }
            // 직전에 연결 다리가 있는 경우 - 1-1) 무조건 공백 생성
            if (previousBridgeExists) {
                ladderRow.add("     ");
                previousBridgeExists = false;
            }
            // 직전에 연결 다리가 없는 경우 - 2) 공백 생성
            if (!previousBridgeExists && randomValue == 0) {
                ladderRow.add("     ");
                previousBridgeExists = false;
            }
            ladderRow.add("|");
            widthCount++;
            if (widthCount == widthOfLadder) {
                break;
            }
        }
        return ladderRow;
    }
}
