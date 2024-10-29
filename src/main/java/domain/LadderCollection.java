package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderCollection {
    private static List<List<String>> ladderLayers;

    public LadderCollection(int heightOfLadder, int widthOfLadder) {
        ladderLayers = new ArrayList<>();
        generateLadderLayers(heightOfLadder, widthOfLadder);
    }

    private void generateLadderLayers(int heightOfLadder, int widthOfLadder) {
        for (int i = 0; i < heightOfLadder; i++) {
            ladderLayers.add(Ladder.generateLadderRow(widthOfLadder));
        }
    }

    public static List<List<String>> getLadderLayers() {
        return ladderLayers;
    }

    public static List<String> getLadderLayer(int index) {
        return ladderLayers.get(index);
    }
}
