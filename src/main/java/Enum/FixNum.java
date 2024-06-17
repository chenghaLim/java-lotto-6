package Enum;

public enum FixNum {
    MIN_MONEY(1000),
    LIST_SIZE(6),
    MIN_NUM(1),
    MAX_NUM(45),
    PLUS_BONUS_NUM_SIZE(7),
    WINNING_MIN_COUNT(3),
    PERCENTAGE(100);

    private int value;

    FixNum(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }
}
