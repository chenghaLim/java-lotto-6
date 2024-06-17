package Enum;

public enum FixString {
    ERROR("[ERROR]"),
    START("구입금액을 입력해 주세요."),
    BUY_LOTTO("개를 구매했습니다."),
    USER_LOTTO("당첨 번호를 입력해 주세요."),
    BONUS_NUM("보너스 번호를 입력해 주세요."),
    RESULT("당첨 통계");

    private String message;

    FixString(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
