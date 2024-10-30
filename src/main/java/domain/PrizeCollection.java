package domain;

import java.util.ArrayList;
import java.util.List;

public class PrizeCollection {

    public static List<String> createPrizeCollection(String input) {
        List<String> prizes = new ArrayList<>();
        StringBuilder prizeBuilder = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == ',') {
                prizes.add(prizeBuilder.toString());
                prizeBuilder.setLength(0);
            }
            if (currentChar != ',') {
                prizeBuilder.append(currentChar);
            }
        }
        if (!prizes.isEmpty()) {
            prizes.add(prizeBuilder.toString());
        }
        return prizes;
    }
}
