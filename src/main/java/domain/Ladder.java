package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final RandomGenerator randomGenerator = new RandomGenerator();

    public static List<String> generateLadderRow(int widthOfLadder) {
        List<String> ladderRow = new ArrayList<>();
        ladderRow.add("|");

        boolean previousBridgeExists = false;
        int verticalCount = 1;

        for (int i = 0; ; i++) {
            int randomValue = randomGenerator.generateRandom();

            // 직전에 연결 다리가 없는 경우 - 1) 연결 다리 생성
            if (!previousBridgeExists && randomValue == 1) {
                ladderRow.add("-----");
                previousBridgeExists = true;
                ladderRow.add("|");
                verticalCount++;
            }
            if (verticalCount == widthOfLadder) {
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
            verticalCount++;
            if (verticalCount == widthOfLadder) {
                break;
            }
        }
        return ladderRow;
    }
}
