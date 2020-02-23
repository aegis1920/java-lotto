package domain;

import java.util.*;

public class LottoTicket {
    private static final int MAX_LOTTO_TICKET_SIZE = 6;
    private static final int MIN_LOTTO_NUMBER_RANGE = 1;
    private static final int MAX_LOTTO_NUMBER_RANGE = 45;

    private List<Integer> lottoTicket;

    public LottoTicket(List<Integer> lottoTicket) {
        validateLottoTicketSize(lottoTicket);
        validateLottoTicketNumberRange(lottoTicket);
        validateDuplicateLottoNumber(lottoTicket);
        Collections.sort(lottoTicket);
        this.lottoTicket = lottoTicket;
    }

    public List<Integer> getLottoTicket() {
        return this.lottoTicket;
    }

    private void validateDuplicateLottoNumber(List<Integer> lottoTicket) {
        Set<Integer> duplicateLottoTicket = new HashSet<>(lottoTicket);
        if (duplicateLottoTicket.size() != lottoTicket.size()) {
            throw new IllegalArgumentException("중복된 로또 숫자를 입력하였습니다.");
        }
    }

    private void validateLottoTicketNumberRange(List<Integer> lottoTicket) {
        if (lottoTicket.stream().anyMatch(LottoTicket::isLottoNumberRange)) {
            throw new IllegalArgumentException("범위를 벗어나는 로또 숫자를 입력하였습니다.");
        }
    }

    private static boolean isLottoNumberRange(int number) {
        return number < MIN_LOTTO_NUMBER_RANGE || number > MAX_LOTTO_NUMBER_RANGE;
    }

    private void validateLottoTicketSize(List<Integer> lottoTicket) {
        if (lottoTicket.size() != MAX_LOTTO_TICKET_SIZE) {
            throw new IllegalArgumentException("로또 숫자의 개수가 잘못되었습니다.");
        }
    }
}
