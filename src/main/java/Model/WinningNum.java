package Model;

import Enum.FixNum;
import Enum.Reward;
import View.Print;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNum {
    private Lotto winningNum;
    private int bonusNum;

    public WinningNum(String winningLotto, String inputBonusNum) {
        this.winningNum = new Lotto(makeWinningNum(winningLotto));
        this.bonusNum = validateDuplicate(winningNum, inputBonusNum);
    }

    public Reward match(Lotto randomNums) {
        int count = randomNums.countMatch(winningNum);
        boolean bonusCheck = randomNums.containNumber(bonusNum);
        return Reward.valueResult(count, bonusCheck);
    }

    private List<Integer> makeWinningNum(String winningLotto) {
        List<Integer> winLotto = new ArrayList<>();
        try {
            String[] temp = winningLotto.split(",");
            for (String s : temp) {
                winLotto.add(Integer.parseInt(s));
            }
        } catch (NumberFormatException e) {
            Print.error();
            throw new IllegalArgumentException();
        }
        return winLotto;
    }

    private int validateDuplicate(Lotto winningLotto, String inputBonusNum) {
        Set<Integer> duplicateCheck = new HashSet<>(winningLotto.getNumbers());
        try {
            duplicateCheck.add(Integer.parseInt(inputBonusNum));

            if (duplicateCheck.size() != FixNum.PLUS_BONUS_NUM_SIZE.get()) {
                Print.error();
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            Print.error();
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(inputBonusNum);
    }
}
