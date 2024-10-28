package domain;

import java.util.ArrayList;
import java.util.List;

public class LadderCollection {
    private static List<List<String>> ladderLayers;

    public LadderCollection(int numberOfLayers, int widthOfLadder) {
        ladderLayers = new ArrayList<>();
        generateLadderLayers(numberOfLayers, widthOfLadder);
    }

    private void generateLadderLayers(int numberOfLayers, int widthOfLadder) {
        for(int i = 0; i < numberOfLayers; i++) {
            ladderLayers.add(Ladder.generateLadderRow(widthOfLadder));
        }
    }

    public static List<List<String>> getLadderLayers() {
        return ladderLayers;
    }
}
