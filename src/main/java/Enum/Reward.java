package Enum;

import View.Print;

public enum Reward {
    FIRST(6, 2_000_000_000, "6개 일치 (2,000,000,000원) - "),
    SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5, 1_500_000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50_000, "4개 일치 (50,000원) - "),
    FIVETH(3, 5_000, "3개 일치 (5,000원) - "),
    MISS(0, 0, "");


    private int count;
    private int reward;
    private String message;

    Reward(int count, int reward, String message) {
        this.count = count;
        this.reward = reward;
        this.message = message;
    }

    public int getReward() {
        return reward;
    }

    public static Reward valueResult(int count, boolean bonusMatch) {
        if (count < FixNum.WINNING_MIN_COUNT.get()) {
            return MISS;
        }

        if (SECOND.count == count && bonusMatch) {
            return SECOND;
        }

        for (Reward reward : values()) {
            if (reward.count == count && reward != SECOND) {
                return reward;
            }
        }

        throw new IllegalArgumentException(FixString.ERROR.get());
    }

    public void printMessage(int count) {
        if (this != MISS) {
            Print.resultMessage(message, count);
        }
    }
}

