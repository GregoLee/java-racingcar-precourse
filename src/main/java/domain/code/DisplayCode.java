package domain.code;

public enum DisplayCode {
	ENTERING_CARS, ROUNDS, IN_GAME, END_GAME;

	public boolean isEnteringCars() {
		return this == ENTERING_CARS;
	}

	public boolean isRounds() {
		return this == ROUNDS;
	}

	public boolean isInGame() {
		return this == IN_GAME;
	}

	public boolean isEndGame() {
		return this == END_GAME;
	}
}
