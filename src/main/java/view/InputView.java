package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputPlayerName() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }
    // 관련 예외 상황(PlayerCollection 클래스에 생성 예정)
    // 예외 상황 1: 플레이어의 이름 5글자 초과 시 예외 발생
    // 예외 상황 2: 플레이어의 이름에 영어,숫자,한글이 아닌 문자가 입력되었을 때 예외 발생


    public static String inputPrizeOfResult() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return scanner.nextLine();
    }
    // 예외 상황 1: 쉼표로 나눈 실행결과의 개수가 플레이어의 수보다 적을 때

    public static int ladderHeight() {
        System.out.println("최대 사다리의 높이는 몇 개인가요?");
        return scanner.nextInt();
    }
    // 예외 상황 1: 0 이하의 정수가 입력 되었을 때
    // 예외 상황 2: 숫자가 아닌 다른 문자가 입력되었을 때

    public static String inputPlayerPrize() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine();
    }
    // 예외 상황 1: 플레이어 목록에 없는 이름을 입력했을 때

    public static void clearScannerBuffer() {
        scanner.nextLine();
    }

    public static void closeScanner() {
        scanner.close();
    }
}
