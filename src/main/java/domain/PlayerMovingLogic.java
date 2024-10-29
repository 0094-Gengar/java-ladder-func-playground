package domain;

import java.util.List;

public class PlayerMovingLogic {
    private static LadderCollection ladderCollection;

    public PlayerMovingLogic(LadderCollection ladderCollection) {
        this.ladderCollection = ladderCollection;
    }

    // 오른쪽에 연결 다리 있을 시(position++;)
    public void moveRight(Player player) {
        int position = player.getPosition();
        List<String> ladder = LadderCollection.getLadderLayer();

        if (position + 1 < ladder.size() && ladder.get(position + 1).equals("-----")) {
            player.setPosition(position + 1);
        }
    }

    // 왼쪽에 연결 다리 있을 시(position--;)
    public void moveLeft(Player player) {
        int position = player.getPosition();
        List<String> ladder = LadderCollection.getLadderLayer();

        if (position - 1 >= 0 && ladder.get(position - 1).equals("-----")) {
            player.setPosition(position - 1);
        }
    }

    // 연결 다리 없을 시(position=position;)
    public void moveDown(Player player) {
        int position = player.getPosition();
        List<String> ladder = LadderCollection.getLadderLayer();

        player.setPosition(position);
    }
}
