package domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerCollection {

    public static List<Person> makePlayerCollection(String input) {
        List<Person> players = new ArrayList<>();
        StringBuilder nameBuilder = new StringBuilder();
        int position = 0;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == ',') {
                players.add(new Person(nameBuilder.toString().trim(), position++));
                nameBuilder.setLength(0);
            }
            if (currentChar != ',') {
                nameBuilder.append(currentChar);
            }
        }
        if (!nameBuilder.isEmpty()) {
            players.add(new Person(nameBuilder.toString().trim(), position++));
        }
        return players;
    }
}
