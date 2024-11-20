package view;

import domain.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static domain.PlayerRoster.createPlayerCollection;
import static domain.PrizeCollection.createPrizeCollection;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<Player> players = new ArrayList<>();
    private static final int PLAYERS_MAX_NAME_LENGTH = 5;

    public static String inputPlayerName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String playerName = scanner.nextLine();

        players = createPlayerCollection(playerName);

        validatePlayerNameUnderFive(players);

        return playerName;
    }

    public static void validatePlayerNameUnderFive(final List<Player> players) {
        for (Player player : players) {
            if (player.getName().length() > PLAYERS_MAX_NAME_LENGTH) {
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
        return ladderHeight;
    }



    public static String inputPlayerPrize() {
        System.out.println("결과를 보고 싶은 사람은?");

        return scanner.nextLine();
    }

//    public static void validatePlayerName(final String playerName) {
//        for (Player player : players) {
//            if (!player.getName().equals(playerName) && !playerName.equals("all")) {
//                throw new IllegalArgumentException("플레이어 중 해당 이름을 가진 사람은 없습니다.");
//            }
//        }
//    }
    // 위치가 이상함...

    public static void clearScannerBuffer() {
        scanner.nextLine();
    }

    public static void closeScanner() {
        scanner.close();
    }
}
