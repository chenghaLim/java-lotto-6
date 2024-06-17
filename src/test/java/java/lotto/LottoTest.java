package lotto;

import Model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호와 당첨 번호 조회해서 맞은 갯수세기")
    @Test
    void countMatch() {
        Lotto lotto = new Lotto((new ArrayList<>(List.of(1, 2, 3, 4, 5, 6))));

        assertEquals(6, lotto.countMatch(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6)))));
        assertEquals(5, lotto.countMatch(new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 7)))));
        assertEquals(0, lotto.countMatch(new Lotto(new ArrayList<>(List.of(7, 8, 9, 10, 11, 12)))));
    }
}