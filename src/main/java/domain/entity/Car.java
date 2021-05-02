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
}
