package domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerCollection {

    public static List<Player> createPlayerCollection(String input) {
        List<Player> players = new ArrayList<>();
        StringBuilder nameBuilder = new StringBuilder();
        int position = 0;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (currentChar == ',') {
                players.add(new Player(nameBuilder.toString().trim(), position++));
                nameBuilder.setLength(0);
            }
            if (currentChar != ',') {
                nameBuilder.append(currentChar);
            }
        }
        if (!nameBuilder.isEmpty()) {
            players.add(new Player(nameBuilder.toString().trim(), position++));

            // 예외 상황 1: 플레이어의 이름 5글자 초과 시 예외 발생
            // 예외 상황 2: 플레이어의 이름에 영어,숫자,한글이 아닌 문자가 입력되었을 때 예외 발생
        }
        return players;
    }
}
