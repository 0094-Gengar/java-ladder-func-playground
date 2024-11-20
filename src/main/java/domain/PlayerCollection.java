package domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerCollection {

    public static List<Player> createPlayerCollection(String input) {
        List<Player> players = new ArrayList<>();
        int position = 0;
        for (String name : input.split(",")) {
            players.add(new Player(name.trim(), position++));
        }
        return players;
    }
}
