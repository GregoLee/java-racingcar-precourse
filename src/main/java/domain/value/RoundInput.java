package domain.value;

import exception.IllegalRoundInputException;

public class RoundInput {
	private int round;

	public void setRound(int round) {
		this.round = round;
	}

	public int getRound() {
		return round;
	}

	public static RoundInput generate(String input) throws IllegalRoundInputException {
		RoundInput roundInput = new RoundInput();
		int round = parseInt(input);
		validateRound(round);
		roundInput.setRound(round);
		return roundInput;
	}

	private static void validateRound(int round) throws IllegalRoundInputException {
		if (round < 1) {
			throw new IllegalRoundInputException("라운드 횟수는 1회 이상으로 입력해 주세요.");
		}
	}

	private static int parseInt(String input) {
		try {
			return Integer.parseInt(input);
		} catch(NumberFormatException e) {
			throw new NumberFormatException("라운드 횟수는 1 ~ Integer.MAX_VALUE 사이 자연수로 입력해주세요.");
		}
	}
}
