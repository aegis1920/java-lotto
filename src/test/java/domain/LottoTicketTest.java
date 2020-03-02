package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoTicketTest {
    private static Stream<List<LottoNumber>> lottoTicketSetUp() {
        return Stream.of(
                IntStream.of(1, 2, 3, 4, 5).mapToObj(LottoNumber::from).collect(Collectors.toList()),
                IntStream.of(1, 2, 2, 3, 4, 5).mapToObj(LottoNumber::from).collect(Collectors.toList()),
                IntStream.of(1, 2, 3, 4, 5, 6, 7).mapToObj(LottoNumber::from).collect(Collectors.toList())
        );
    }

    @DisplayName("Should_LottoTicket 유효성 통과_When_LottoTicket 생성")
    @ParameterizedTest
    @MethodSource("lottoTicketSetUp")
    void lottoTicketConstructorTest(List<LottoNumber> input) {
        Assertions.assertThatThrownBy(() -> {
            new LottoTicket(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("Should_true 반환_When_로또 티켓 안에 로또 번호가 있다면 ")
    @Test
    void containsLottoNumberTest() {
        LottoTicket lottoTicket = new LottoTicket(IntStream.of(1, 2, 3, 4, 5, 7).mapToObj(LottoNumber::from).collect(Collectors.toList()));
        LottoNumber lottoNumber = LottoNumber.from(7);

        Assertions.assertThat(lottoTicket.containsLottoNumber(lottoNumber)).isTrue();
    }
}
