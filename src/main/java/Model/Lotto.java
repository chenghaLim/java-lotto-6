package Model;

import Enum.FixNum;
import View.Print;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateOver(numbers);
        rangeValue(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateOver(List<Integer> numbers) {
        Set<Integer> overCheck = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            overCheck.add(numbers.get(i));
        }

        if (overCheck.size() != FixNum.LIST_SIZE.get()) {
            Print.error();
            throw new IllegalArgumentException();
        }
    }

    public int countMatch(Lotto winningNum) {
        return (int) numbers.stream().
                filter(winningNum::containNumber).
                count();
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }

    private void rangeValue(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (!(FixNum.MIN_NUM.get() <= numbers.get(i) && numbers.get(i) <= FixNum.MAX_NUM.get())) {
                Print.error();
                throw new IllegalArgumentException();
            }
        }
    }

    // TODO: 추가 기능 구현
}
