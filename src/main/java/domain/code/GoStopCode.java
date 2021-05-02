package domain.code;

import exception.IllegalRandomIntegerValueException;

public enum GoStopCode {
	GO, STOP;

	public boolean isGo() {
		return GoStopCode.GO == this;
	}

	public boolean isStop() {
		return GoStopCode.STOP == this;
	}

	public static GoStopCode distinguishGoStop(int num) throws IllegalRandomIntegerValueException {
		if (3 < num && num < 10) {
			return GoStopCode.GO;
		}
		if (-1 < num && num < 4) {
			return GoStopCode.STOP;
		}
		throw new IllegalRandomIntegerValueException("0~9 사이의 랜덤한 정수의 값으로만 자동차가 전진(Go), 정지(Stop) 여부를 판별할 수 있습니다.");
	}

	public static int randomInteger0To9() {
		return (int) (Math.random() * 10);
	}

	public static GoStopCode getRandomGoStopCode() throws IllegalRandomIntegerValueException {
		return distinguishGoStop(randomInteger0To9());
	}
}
