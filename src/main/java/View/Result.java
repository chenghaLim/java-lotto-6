package View;

import Controller.Controller;
import Enum.Reward;
import Model.Lotto;
import Model.Money;
import Model.WinningNum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Result {
    private List<Lotto> lottoList = new ArrayList<>();
    private Controller controller = new Controller();

    public void run() {
        try {
            start();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private void start() {
        Print.start();
        Money money = new Money(Input.inputMoney());

        Print.buyLotto(money.quantity());

        lottoList = controller.lottoList(money.quantity());
        printLottoList(lottoList, money.quantity());

        Print.userLotto();
        String winningNums = Input.inputWinLottoNum();
        Print.bonusNum();
        String bonus = Input.inputBonusNum();
        WinningNum winningNum = new WinningNum(winningNums, bonus);

        lottoResult(winningNum, money.quantity());
    }

    private void lottoResult(WinningNum winningNum, int quntity) {
        Print.result();
        Map<Reward, Integer> result = controller.lottoResult(lottoList, winningNum);
        printResult(result);

        double rateOfReturn = controller.rateOfReturn(result, quntity);
        Print.printRevenueRate(rateOfReturn);
    }

    private void printLottoList(List<Lotto> list, int quntity) {
        for (Lotto lotto : list) {
            System.out.println(lotto.getNumbers());
        }
    }

    // lottoResult 출력하기
    private void printResult(Map<Reward, Integer> result) {
        for (int i = Reward.values().length - 1; i >= 0; i--) {
            Reward.values()[i].printMessage(result.get(Reward.values()[i]));
        }
    }

}
