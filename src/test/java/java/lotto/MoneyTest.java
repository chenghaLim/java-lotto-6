package lotto;

import Model.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {

    @DisplayName("입력한 금액이 숫자가 아닐때")
    @Test
    void inputMoneyNotNum() {
        Assertions.assertThatThrownBy(() -> new Money("가나다"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 금액이 음수 일때")
    @Test
    void inputMoneyNegative() {
        Assertions.assertThatThrownBy(() -> new Money("-1000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 금액이 1000의 배수가 아닐때")
    @Test
    void inputMoneyNotMultiplesOf1000() {
        Assertions.assertThatThrownBy(() -> new Money("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
