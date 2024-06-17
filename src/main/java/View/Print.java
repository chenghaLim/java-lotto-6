package View;

import Enum.FixString;

public class Print {

    public static void start() {
        System.out.println(FixString.START.get());
    }

    public static void error() {
        System.out.println(FixString.ERROR.get());
    }

    public static void buyLotto(int quntity) {
        System.out.println(quntity + FixString.BUY_LOTTO.get());
    }

    public static void userLotto() {
        System.out.println(FixString.USER_LOTTO.get());
    }

    public static void bonusNum() {
        System.out.println(FixString.BONUS_NUM.get());
    }

    public static void result() {
        System.out.println(FixString.RESULT.get());
        System.out.println("---");
    }

    public static void resultMessage(String message, int count) {
        System.out.println(message + count + "개");
    }

    public static void printRevenueRate(double EarningRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", EarningRate) + "%입니다.");
    }
}
