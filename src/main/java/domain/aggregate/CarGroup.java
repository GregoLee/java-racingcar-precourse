package domain.aggregate;

import java.util.ArrayList;
import java.util.List;

import domain.code.GoStopCode;
import domain.entity.Car;
import exception.IllegalCarNameException;
import exception.IllegalRandomIntegerValueException;

public class CarGroup {
	private List<Car> cars = new ArrayList<>();

	public static CarGroup generate(String[] carNames) throws IllegalCarNameException {
		CarGroup carGroup = CarGroup.generate();
		for (String carName : carNames) {
			carGroup.getCars().add(new Car(carName));
		}
		return carGroup;
	}

	List<Car> getCars() {
		return this.cars;
	}

	private static CarGroup generate() {
		return new CarGroup();
	}

	public int size() {
		return this.cars.size();
	}

	private List<Car> findWinners() {
		List<Car> winners = new ArrayList<>();
		for (Car car : this.cars) {
			this.calculateWinner(winners, car);
		}
		return winners;
	}

	/**
	 * 승리자를 계산한다.
	 * - 승리자가 0명인 경우 : 현재 자동차를 잠정 우승자로 하고 리스트에 넣는다.
	 * - 승리자가 1명 이상인 경우 : 잠정 우승자의 첫번째 값과 비교한다.
	 *   - 잠정우승자보다 큰 경우(compareTo : 1) : 잠정 우승자 값을 비우고 새로운 승리자로 채워넣는다.
	 *   - 잠정우승자와 같은 경우(compareTo : 0) : 잠정 우승자와 같이 리스트에 들어간다.
	 *   - 잠정우승자보다 낮은 경우(compareTo : -1) : 잠정 우승자의 값을 유지한다.
	 * @param winners
	 * @param car
	 */
	private void calculateWinner(List<Car> winners, Car car) {
		if (winners.size() == 0) {
			winners.add(car);
			return;
		}
		if (car.compareTo(winners.get(0)) == 0) {
			winners.add(car);
		}
		if (car.compareTo(winners.get(0)) == 1) {
			winners.clear();
			winners.add(car);
		}
	}

	public String makeMsgWinners() {
		List<Car> winners = this.findWinners();
		StringBuilder msg = new StringBuilder();
		for (int i = 0; i < winners.size(); i++) {
			String winnerName = winners.get(i).getCarName().getName();
			msg.append((i == winners.size() - 1) ? winnerName : winnerName + ", ");
		}
		msg.append("가 최종 우승했습니다.");
		return msg.toString();
	}

	public String makeMsgInRacing() {
		StringBuilder msg = new StringBuilder();
		for (Car car : this.cars) {
			msg.append(car.makeMsg()).append("\n");
		}
		return msg.toString();
	}

	public void playRound() throws IllegalRandomIntegerValueException {
		for (Car car : this.cars) {
			car.calculateDistance(GoStopCode.getRandomGoStopCode());
		}
	}
}
