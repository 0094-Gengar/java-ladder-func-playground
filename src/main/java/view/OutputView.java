package view;

import domain.LadderCollection;
import domain.Player;
import domain.PrizeCollection;

import java.util.List;

public class OutputView {
    private LadderCollection ladderCollection;
    private List<Player> players;
    private List<String> prizes;

    public OutputView(LadderCollection ladderCollection, List<Player> players, String results) {
        this.ladderCollection = ladderCollection;
        this.players = players;
        this.prizes = PrizeCollection.createPrizeCollection(results);
    }

    public void resultOfLadders() {
        System.out.println("사다리 결과");
        printPlayerNames();
        ladderCollection.getLadderLayers().forEach(row ->
                System.out.println(String.join("", row))
        );
        printPrize();
    }

    private void printPlayerNames() {
        players.forEach(player ->
                System.out.print(String.format("%-5s ", player.getName()))
        );
        System.out.println();
    }

    private void printPrize() {
        prizes.forEach(prize ->
                System.out.print(String.format("%-5s ", prize))
        );
        System.out.println();
    }

    public void resultOfPrize(String playerName) {
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

    private String getResultForPlayer(String playerName) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                int position = player.getPosition();
                return prizes.get(position);
            }
        }
        return "예외 발생";
    }
}
