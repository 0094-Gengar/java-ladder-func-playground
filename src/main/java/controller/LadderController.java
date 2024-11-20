package controller;

import domain.LadderCollection;
import domain.Player;
import domain.PlayerCollection;
import domain.PlayerMovingLogic;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderController {
    private LadderCollection ladderCollection;
    private PlayerMovingLogic playerMovingLogic;

    public void run() {
        List<Player> players = inputPlayerNames();
        generateLadders(players.size());
        String inputResults = InputView.inputPrizeOfResult();
        new OutputView(ladderCollection, players, inputResults);
        printResultOfLadders();
        startLadderGame(players);
        resultOfLadderGames();
        Runtime.getRuntime().addShutdownHook(new Thread(InputView::closeScanner));
    }

    private List<Player> inputPlayerNames() {
        String inputPlayers = InputView.inputPlayerName();
        return PlayerCollection.createPlayerCollection(inputPlayers);
    }

    private void generateLadders(int widthOfLadder) {
        int heightOfLadder = InputView.ladderHeight();
        validateLadderHeight(heightOfLadder);
        InputView.clearScannerBuffer();
        this.ladderCollection = new LadderCollection(heightOfLadder, widthOfLadder);
        this.playerMovingLogic = new PlayerMovingLogic(ladderCollection);
    }

    public static void validateLadderHeight(final int heightOfLadder) {
        final int LADDERS_MIN_HEIGHT = 1;
        if (heightOfLadder < LADDERS_MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상이어야 합니다.");
        }
    }

    private void printResultOfLadders() {
        OutputView.resultOfLadders();
    }

    private void startLadderGame(List<Player> players) {
        playerMovingLogic.updatePlayerPositions(players);
    }

    private void resultOfLadderGames() {
        String playerName = InputView.inputPlayerPrize();
        OutputView.resultOfPrize(playerName);
    }
}
