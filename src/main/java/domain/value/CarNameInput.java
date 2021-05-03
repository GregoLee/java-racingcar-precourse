package domain.value;

import exception.IllegalCarNameException;

public class CarNameInput {
	private String[] carNames;

	private void setCarNames(String[] tempCarNames) {
		this.carNames = tempCarNames;
	}

	public String[] getCarNames() {
		return this.carNames;
	}

	public static CarNameInput generate(String input) throws IllegalCarNameException {
		CarNameInput carNameInput = new CarNameInput();
		String[] tempCarNames = input.split(",");
		validateCarNameLengthUnder1(tempCarNames);
		validateCarNameLengthOver5(tempCarNames);
		carNameInput.setCarNames(tempCarNames);
		return carNameInput;
	}

	private static void validateCarNameLengthOver5(String[] tempCarNames) throws IllegalCarNameException {
		for (String carName : tempCarNames) {
			checkCarNameOverLength5(carName);
		}
	}

	private static void checkCarNameOverLength5(String carName) throws IllegalCarNameException {
		if (5 < carName.length()) {
			throw new IllegalCarNameException("자동차 이름은 6자 이하이어야 합니다. 자동차 이름은 ',(comma)'로 구분합니다.");
		}
	}

	private static void validateCarNameLengthUnder1(String[] tempCarNames) throws IllegalCarNameException {
		for (String carName : tempCarNames) {
			checkCarNameUnderLength1(carName);
		}
	}

	private static void checkCarNameUnderLength1(String carName) throws IllegalCarNameException {
		if (carName.length() < 1) {
			throw new IllegalCarNameException("자동차 이름은 반드시 필요합니다.");
		}
	}
}
