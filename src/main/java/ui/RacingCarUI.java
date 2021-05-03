package ui;

import java.io.IOException;

import domain.aggregate.CarGroup;
import domain.code.DisplayCode;
import domain.value.CarNameInput;
import domain.value.RoundInput;
import exception.IllegalCarNameException;
import exception.IllegalRandomIntegerValueException;
import exception.IllegalRoundInputException;

public class RacingCarUI {
	private CarGroup carGroup = null;
	private DisplayCode displayCode = DisplayCode.ENTERING_CARS;
	private RacingCarIO racingCarIO = new RacingCarIO();
	private RoundInput roundInput = null;

	public void selectDisplay() throws IllegalRandomIntegerValueException {
		while (!this.displayCode.isEndGame()) {
			selectDisplayInGame();
		}
		displayEndGame();
	}

	private void selectDisplayInGame() throws IllegalRandomIntegerValueException {
		if (this.displayCode.isEnteringCars()) {
			displayEnteringCars();
		}
		if (this.displayCode.isRounds()) {
			displayRounds();
		}
		if (this.displayCode.isInGame()) {
			displayInGame();
		}
	}

	private void displayEnteringCars() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		try {
			this.carGroup = CarGroup
				.generate(CarNameInput.generate(this.racingCarIO.readLineFromSystemIn()).getCarNames());
			this.displayCode = DisplayCode.ROUNDS;
		} catch (IOException | IllegalCarNameException e) {
			System.out.println(e.getMessage());
		}
	}

	private void displayRounds() {
		System.out.println("시도할 회수는 몇회인가요?");
		try {
			this.roundInput = RoundInput.generate(this.racingCarIO.readLineFromSystemIn());
			this.displayCode = DisplayCode.IN_GAME;
		} catch (IOException | IllegalRoundInputException | NumberFormatException e) {
			System.out.println(e.getMessage());
		}
	}

	private void displayInGame() throws IllegalRandomIntegerValueException {
		System.out.println("실행 결과");
		for (int i = 0; i < this.roundInput.getRound(); i++) {
			this.carGroup.playRound();
			System.out.println(this.carGroup.makeMsgInRacing());
		}
		this.displayCode = DisplayCode.END_GAME;
	}

	private void displayEndGame() {
		System.out.println(this.carGroup.makeMsgWinners());
	}
}
