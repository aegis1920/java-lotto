package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

public class LottoCalculatorTest {

    @DisplayName("수익률을 리턴해주는 메서드 테스트")
    @ParameterizedTest
    @CsvSource(value = {"MATCH_THREE,1,1000,500", "MATCH_FOUR,2,1000,10000", "MATCH_FIVE,3,4500,100000"})
    void calculateProfit(RankType winningStr, int winningCount, int money, int expected) {
        Map<RankType, Integer> winningCountMap = new HashMap<>();

        winningCountMap.put(winningStr, winningCount);

        Assertions.assertThat(LottoCalculator.getProfit(winningCountMap, money)).isEqualTo(expected);
    }


}
