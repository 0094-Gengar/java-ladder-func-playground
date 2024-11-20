package controller;

import domain.LadderCollection;
import domain.Player;
import domain.PlayerCollection;
import domain.PlayerMovingLogic;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderController {
    private List<Player> players;
    private LadderCollection ladderCollection;
    private PlayerMovingLogic playerMovingLogic;

    public void run() {
        inputPlayerNames();
        generateLadders();
        printResultOfLadders();
        startLadderGame();
        resultOfLadderGames();
        Runtime.getRuntime().addShutdownHook(new Thread(InputView::closeScanner));
    }

    private void inputPlayerNames() {
        String inputPlayers = InputView.inputPlayerName();
        this.players = PlayerCollection.createPlayerCollection(inputPlayers);
    }

    private void generateLadders() {
        int heightOfLadder = InputView.ladderHeight();
        validateLadderHeight(heightOfLadder);
        InputView.clearScannerBuffer();
        String inputResults = InputView.inputPrizeOfResult();
        int widthOfLadder = players.size();
        this.ladderCollection = new LadderCollection(heightOfLadder, widthOfLadder);
        this.playerMovingLogic = new PlayerMovingLogic(ladderCollection);
        new OutputView(ladderCollection, players, inputResults);
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

    private void startLadderGame() {
        playerMovingLogic.updatePlayerPositions(players);
    }

    private void resultOfLadderGames() {
        String playerName = InputView.inputPlayerPrize();
        OutputView.resultOfPrize(playerName);
    }
}
