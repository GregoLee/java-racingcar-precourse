package domain.entity;

import domain.code.GoStopCode;
import domain.value.CarDistance;
import domain.value.CarName;
import exception.IllegalCarNameException;

public class Car {
	private CarName carName;
	private CarDistance distance;

	public Car(String carName) throws IllegalCarNameException {
		this.carName = CarName.generate(carName);
		this.distance = CarDistance.generate();
	}

	public CarDistance getDistance() {
		return this.distance;
	}

	public CarName getCarName() {
		return this.carName;
	}

	public void increaseDistance() {
		this.distance.increase();
	}

	public void calculateDistance(GoStopCode inputCode) {
		if (inputCode.isGo()) {
			increaseDistance();
		}
	}

	public String makeMsg() {
		return getCarName().getName() + " : " + getDistance().makeMsg();
	}

	/**
	 * 현재 자동차 인스턴스가 간 거리와 파라메터가 간 거리를 비교한다.
	 * -1 : 현재 자동차 인스턴스가 간 거리가 짧다.
	 * 0 : 두 자동차가 간 거리가 동일하다.
	 * 1 : 현재 자동차 인스턴스가 간 거리가 길다.
	 * @param car
	 * @return
	 */
	public int compareTo(Car car) {
		if (this.getDistance().length() < car.getDistance().length()) {
			return -1;
		}
		if (this.getDistance().length() > car.getDistance().length()) {
			return 1;
		}
		return 0;
	}
}
