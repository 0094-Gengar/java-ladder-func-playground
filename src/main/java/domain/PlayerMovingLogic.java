package domain;

import java.util.List;

public class PlayerMovingLogic {
    private LadderCollection ladderCollection;

    public PlayerMovingLogic(LadderCollection ladderCollection) {
        this.ladderCollection = ladderCollection;
    }

    // 모든 사다리 층을 순회하며 플레이어 이동 처리
    public void updatePlayerPositions(List<Player> players) {
        for (Player player : players) {
            movePlayers(player);
        }

    }

    private void movePlayers(Player player) {
        int position = player.getPosition();

        for (List<String> ladderRow : ladderCollection.getLadderLayers()) {
            // 현재 위치에서 오른쪽에 연결 다리가 있는 경우
            if (position * 2 + 1 < ladderRow.size() && ladderRow.get(position * 2 + 1).equals("-----")) {
                position += 1;
            }
            // 현재 위치에서 왼쪽에 연결 다리가 있는 경우
            else if (position * 2 - 1 >= 0 && ladderRow.get(position * 2 - 1).equals("-----")) {
                position -= 1;
            }
            player.setPosition(position);
        }
    }
}