import domain.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LadderGameTest {

    @Test
    public void 플레이어_컬랙션_테스트() {
        // Given
        String inputPlayerName = "shin,ji,hoon";
        // When
        List<Player> players = PlayerCollection.createPlayerCollection(inputPlayerName);
        // Then
        assertEquals(3, players.size());
        assertEquals("shin", players.get(0).getName());
        assertEquals("ji", players.get(1).getName());
        assertEquals("hoon", players.get(2).getName());
    }

    @Test
    public void 사다리_한칸_생성_테스트() {
        int widthOfLadder = 4;
        MockRandomGenerator randomGenerator = new MockRandomGenerator(1);
        Ladder ladder = new Ladder(randomGenerator);

        List<String> ladderRow = Ladder.generateLadderRow(widthOfLadder);

        assertEquals("|-----|     |-----|", String.join("", ladderRow));
    }

    private static class MockRandomGenerator extends RandomGenerator {
        private final int fixedValue;

        public MockRandomGenerator(int fixedValue) {
            this.fixedValue = fixedValue;
        }

        @Override
        public int generateRandom() {
            return fixedValue;
        }
    }

//    @Test
//    public void 플레이어_이동_테스트() {
//
//    }
//
//    @Test
//    public void 실행결과_컬랙션_테스트() {
//
//    }

    // 입력 테스트
    // 출력 테스트
    // 예외 테스트
}
