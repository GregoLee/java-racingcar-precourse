package domain.code;

import exception.IllegalRandomIntegerValueException;

public enum GoStopCode {
	GO, STOP;

	public boolean isGo() {
		return GO == this;
	}

	public boolean isStop() {
		return STOP == this;
	}

	public static GoStopCode distinguishGoStop(int num) throws IllegalRandomIntegerValueException {
		if (3 < num && num < 10) {
			return GO;
		}
		if (-1 < num && num < 4) {
			return STOP;
		}
		throw new IllegalRandomIntegerValueException("0~9 사이의 랜덤한 정수의 값으로만 자동차가 전진(Go), 정지(Stop) 여부를 판별할 수 있습니다.");
	}

	public static int randomInteger0To9() {
		return (int) (Math.random() * 10);
	}

	public static GoStopCode getRandomGoStopCode() throws IllegalRandomIntegerValueException {
		try {
			return distinguishGoStop(randomInteger0To9());
		} catch (IllegalRandomIntegerValueException e) {
			throw new IllegalRandomIntegerValueException("0~9 사이의 랜덤한 정수 값이 들어오지 않았습니다. 시스템 오류로 게임을 종료합니다.");
		}
	}
}
