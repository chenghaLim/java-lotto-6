package View;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static String inputMoney() {
        return Console.readLine();
    }

    public static String inputWinLottoNum() {
        String winingNum = Console.readLine();
        isvalidateInput(winingNum);
        return winingNum;
    }

    public static String inputBonusNum() {
        return Console.readLine();
    }

    private static void isvalidateInput(String winingNum) {
        if (winingNum.contains("\"") || winingNum.contains(",,")) {
            Print.error();
            throw new IllegalArgumentException();
        }
    }
}
