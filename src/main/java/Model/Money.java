package Model;

import Enum.FixNum;
import View.Print;

public class Money {
    private int money;

    public Money(String money) {
        int moneyMum = validateNm(money);
        validateMoney(moneyMum);
        this.money = moneyMum;
    }

    public int quantity() {
        return money / FixNum.MIN_MONEY.get();
    }

    private void validateMoney(int money) {
        isvalidateNum(money);
        validateDivide(money);
    }

    private static int validateNm(String money) {
        try {
            return Integer.parseInt(money);
        } catch (NumberFormatException e) {
            Print.error();
            throw new IllegalArgumentException();
        }
    }

    private void isvalidateNum(int money) {
        if (money <= 0) {
            Print.error();
            throw new IllegalArgumentException();
        }
    }

    private void validateDivide(int money) {
        if (money % FixNum.MIN_MONEY.get() != 0) {
            Print.error();
            throw new IllegalArgumentException();
        }
    }
}
