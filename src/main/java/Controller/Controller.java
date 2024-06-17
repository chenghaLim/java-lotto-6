package Controller;

import Enum.FixNum;
import Enum.Reward;
import Model.Lotto;
import Model.WinningNum;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;


public class Controller {

    // 로또 랜덤 넘버 뽑기
    private List<Integer> random() {
        List<Integer> lottoList = new ArrayList<>(Randoms.pickUniqueNumbersInRange(FixNum.MIN_NUM.get(), FixNum.MAX_NUM.get(), FixNum.LIST_SIZE.get()));
        Collections.sort(lottoList);
        return lottoList;
    }

    // 금액 만큼 로또 리스트 만들기
    public List<Lotto> lottoList(int quntity) {
        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < quntity; i++) {
            list.add(new Lotto(random()));
        }
        return list;
    }

    // 상금을 카운트해서 넣을 Map
    private Map<Reward, Integer> resultList() {
        Map<Reward, Integer> result = new LinkedHashMap<>();

        for (Reward reward : Reward.values()) {
            result.put(reward, 0);
        }
        return result;
    }

    // 상금에 해당하는 만큼 카운트 넣어주기
    public Map<Reward, Integer> lottoResult(List<Lotto> lottoList, WinningNum winningLotto) {
        Map<Reward, Integer> result = resultList();
        Reward reward;

        for (int i = 0; i < lottoList.size(); i++) {
            reward = winningLotto.match(lottoList.get(i));
            result.put(reward, result.get(reward) + 1);
        }

        return result;
    }

    // 수익률
    public double rateOfReturn(Map<Reward, Integer> result, int quntity) {
        double rateOfReturn = 0;
        for (Reward reward : result.keySet()) {
            rateOfReturn += ((double) (reward.getReward())
                    / (quntity * FixNum.MIN_MONEY.get()) * (result.get(reward)) * (FixNum.PERCENTAGE.get()));

        }
        return rateOfReturn;
    }
}
