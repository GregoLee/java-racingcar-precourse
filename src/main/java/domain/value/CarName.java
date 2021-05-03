package domain.value;

import exception.IllegalCarNameException;

public class CarName {
	private String name;

	private CarName(String input) {
		this.name = input;
	}

	public String getName() {
		return this.name;
	}

	public static CarName generate(String input) throws IllegalCarNameException {
		if (isNotNull(input) && isLengthBetween1And5(input)) {
			return new CarName(input);
		}
		throw new IllegalCarNameException("적절하지 않은 자동차 이름입니다. : " + input);
	}

	private static boolean isNotNull(String input) {
		return input != null;
	}

	private static boolean isLengthBetween1And5(String input) {
		return 0 < input.length() && input.length() < 6;
	}

}
