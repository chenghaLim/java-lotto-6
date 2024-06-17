package lotto;

import Model.WinningNum;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumTest {
    @DisplayName("당첨 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void WinningNum_ByOver_Size() {
        Assertions.assertThatThrownBy(() -> new WinningNum("1, 2, 3, 4, 5, 6, 7", "8"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void winningNumByDuplicatedNumber() {
        Assertions.assertThatThrownBy(() -> new WinningNum("1, 2, 3, 4, 5, 5", "8"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void winningNumAndBonusNumByDuplicated() {
        Assertions.assertThatThrownBy(() -> new WinningNum("1, 2, 3, 4, 5, 6", "6"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
