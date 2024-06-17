package lotto;

import Controller.Controller;
import Enum.Reward;
import Model.Lotto;
import Model.WinningNum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ControllerTest {
    private Controller controller = new Controller();

    @DisplayName("로또 리스트가 입력한 금액에 갯수만큼 만들어질때")
    @Test
    void WhenLottoListNotCreatedByInputMoney() {
        Controller controller = new Controller();
        List<Lotto> lottoList = controller.lottoList(5);
        assertThat(lottoList.size()).isEqualTo(5);
    }

    @DisplayName("당첨금 횟수 세기")
    @Test
    void lottoResult() {
        List<Lotto> lottoList = List.of(
                new Lotto(new ArrayList<>(List.of(1, 2, 3, 4, 5, 6))),
                new Lotto(new ArrayList<>(List.of(4, 5, 6, 7, 8, 9))),
                new Lotto(new ArrayList<>(List.of(7, 8, 9, 10, 11, 12)))
        );
        WinningNum winningNum = new WinningNum("1,2,3,4,5,6", "7");

        Map<Reward, Integer> result = new HashMap<>();
        result.put(Reward.FIRST, 1);
        result.put(Reward.SECOND, 0);
        result.put(Reward.THIRD, 0);
        result.put(Reward.FOURTH, 0);
        result.put(Reward.FIVETH, 1);
        result.put(Reward.MISS, 1);

        assertEquals(result, controller.lottoResult(lottoList, winningNum));
    }

    @DisplayName("수익률 계산")
    @Test
    void rateOfReturn() {
        Map<Reward, Integer> result = new HashMap<>();
        result.put(Reward.FIRST, 1);

        assertEquals(2.0E8, controller.rateOfReturn(result, 1));
    }
}
