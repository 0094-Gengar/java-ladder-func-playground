package view;

import domain.Player;
import domain.PlayerCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static domain.PlayerCollection.createPlayerCollection;
import static domain.PrizeCollection.createPrizeCollection;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Player> players = new ArrayList<>();

    public static String inputPlayerName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String playerName = scanner.nextLine();

        players = createPlayerCollection(playerName);

        validatePlayerNameUnderFive(players);

        return playerName;
    }

    public static List<Player> getPlayers() {
        return players;
    }

    public static void validatePlayerNameUnderFive(final List<Player> players) {
        for (Player player : players) {
            if (player.getName().length() > 5) {
                throw new IllegalArgumentException("사람 이름은 5글자 이하여야 합니다.");
            }
        }
    }

    public static String inputPrizeOfResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String prizeOfResult = scanner.nextLine();

        List<String> prizeCollection = createPrizeCollection(prizeOfResult);

        validatePrizeCount(prizeCollection);

        return prizeOfResult;
    }

    public static void validatePrizeCount(final List<String> prizes) {
        if (prizes.size() != players.size()) {
            throw new IllegalArgumentException("실행 결과의 수가 사람의 수와 다릅니다.");
        }
    }

    public static int ladderHeight() {
        int ladderHeight;
        System.out.println("최대 사다리의 높이는 몇 개인가요?");

        ladderHeight = scanner.nextInt();
        validateLadderHeight(ladderHeight);

        return ladderHeight;
    }

    public static void validateLadderHeight(final int heightOfLadder) {
        if (heightOfLadder < 1) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상이어야 합니다.");
        }
    }
    // 예외 상황 2: 숫자가 아닌 다른 문자가 입력되었을 때
//    public static void validateLadderHeight()

    public static String inputPlayerPrize() {
        System.out.println("결과를 보고 싶은 사람은?");

        String playerPrize = scanner.nextLine();
        validatePlayerName(playerPrize);

        return playerPrize;
    }

    public static void validatePlayerName(final String playerName) {
        for (Player player : players) {
            if (!player.getName().equals(playerName)) {
                throw new IllegalArgumentException("플레이어 중 해당 이름을 가진 사람은 없습니다.");
            }
        }
    }

    public static void clearScannerBuffer() {
        scanner.nextLine();
    }

    public static void closeScanner() {
        scanner.close();
    }
}
