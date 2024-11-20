package view;

import domain.LadderCollection;
import domain.Player;
import domain.PrizeCollection;

import java.util.List;

public class OutputView {
    private static LadderCollection ladderCollection;
    private static List<Player> players;
    private static List<String> prizes;

    public OutputView(LadderCollection ladderCollection, List<Player> players, String results) {
        this.ladderCollection = ladderCollection;
        this.players = players;
        this.prizes = PrizeCollection.createPrizeCollection(results);
    }

    public static void resultOfLadders() {
        System.out.println("사다리 결과");
        printPlayerNames();
        ladderCollection.getLadderLayers().forEach(row ->
                System.out.println(String.join("", row))
        );
        printPrize();
    }

    private static void printPlayerNames() {
        players.forEach(player ->
                System.out.print(String.format("%-5s ", player.getName()))
        );
        System.out.println();
    }

    private static void printPrize() {
        prizes.forEach(prize ->
                System.out.print(String.format("%-5s ", prize))
        );
        System.out.println();
    }

    public static void resultOfPrize(String playerName) {
        System.out.println("실행 결과");
        if ("all".equals(playerName)) {
            players.forEach(player ->
                    System.out.printf("%s : %s\n", player.getName(), getResultForPlayer(player.getName()))
            );
        }
        if (!("all".equals(playerName))) {
            System.out.printf("%s : %s\n", playerName, getResultForPlayer(playerName));
        }
    }

    private static String getResultForPlayer(String playerName) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                int position = player.getPosition();
                return prizes.get(position);
            }
        }
        throw new IllegalArgumentException("플레이어 중 해당 이름을 가진 사람은 없습니다.");
    }
}
