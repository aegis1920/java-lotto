package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoTicketCountTest {

    @DisplayName("Should_유효성 통과_When_ManualLottoTicketQuantity 클래스 생성")
    @ParameterizedTest
    @CsvSource(value = {"1000,500", "14000,f", "14000,"})
    void manualBuyLottoTicketCountConstructorTest(String inputMoney, String inputQuantity) {
        Money money = new Money(inputMoney);
        Assertions.assertThatThrownBy(() -> {
            new LottoTicketCount(money, inputQuantity);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Should_자동 티켓의 갯수_When_수동 티켓의 갯수를 넣음")
    @ParameterizedTest
    @CsvSource(value = {"14000,4,10", "20000,10,10", "100000,50,50"})
    void countAutoLottoTicketsTest(String inputMoney, String inputManualQuantity, int expected) {
        Money money = new Money(inputMoney);
        LottoTicketCount lottoTicketCount = new LottoTicketCount(money, inputManualQuantity);

        AutoCount autoCount = lottoTicketCount.getAutoCount();

        Assertions.assertThat(autoCount.getAutoCount()).isEqualTo(expected);
    }
}
