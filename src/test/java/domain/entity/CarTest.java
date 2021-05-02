package domain.entity;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import domain.code.GoStopCode;
import exception.IllegalCarNameException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarTest {

	@DisplayName("자동차_만들기")
	@ParameterizedTest(name = "{index} - 자동차이름 : {0}")
	@Order(1)
	@CsvSource(value = {"A", "AB", "ABC", "ABCD", "ACBDE", "가", "가나", "가나다", "가나다라", "가나다라마"}, delimiter = ';')
	public void makeCar(String carName) throws IllegalCarNameException {
		Car car = new Car(carName);
		assertThat(car.getDistance().length()).isEqualTo(0);
		assertThat(car.getCarName().getName()).isEqualTo(carName);
	}

	@DisplayName("자동차_만들기_실패_0글자")
	@Test
	@Order(2)
	public void makeCarFailWithStringLength0() {
		assertThatThrownBy(() -> new Car("")).isInstanceOf(IllegalCarNameException.class);
	}

	@DisplayName("자동차_만들기_실패_6글자_이상")
	@ParameterizedTest(name = "{index} - 자동차이름 : {0}")
	@Order(3)
	@CsvSource(value = {"ABCDEF", "가나다라마바"}, delimiter = ';')
	public void makeCarFailWithStringLengthOver5(String carName) {
		assertThatThrownBy(() -> new Car(carName)).isInstanceOf(IllegalCarNameException.class);
	}

	@DisplayName("자동차_전진하기")
	@ParameterizedTest(name = "{index} - 자동차이름 : {0}")
	@Order(4)
	@CsvSource(value = {"A", "AB", "ABC", "ABCD", "ACBDE", "가", "가나", "가나다", "가나다라", "가나다라마"}, delimiter = ';')
	public void goCar(String carName) throws IllegalCarNameException {
		Car car = new Car(carName);
		assertThat(car.getDistance().makeMsg()).isEqualTo("");
		car.increaseDistance();
		assertThat(car.getDistance().makeMsg()).isEqualTo("-");
		car.increaseDistance();
		assertThat(car.getDistance().makeMsg()).isEqualTo("--");
	}

	@DisplayName("자동차_전진하기_GoStopCode")
	@ParameterizedTest(name = "{index} - 자동차이름 : {0}")
	@Order(5)
	@CsvSource(value = {"A", "AB", "ABC", "ABCD", "ACBDE", "가", "가나", "가나다", "가나다라", "가나다라마"}, delimiter = ';')
	public void goCatWithGoStopCode(String carName) throws IllegalCarNameException {
		Car car = new Car(carName);
		assertThat(car.getDistance().makeMsg()).isEqualTo("");
		car.calculateDistance(GoStopCode.GO);
		assertThat(car.getDistance().makeMsg()).isEqualTo("-");
		car.calculateDistance(GoStopCode.STOP);
		assertThat(car.getDistance().makeMsg()).isEqualTo("-");
		car.calculateDistance(GoStopCode.GO);
		assertThat(car.getDistance().makeMsg()).isEqualTo("--");
	}

	@DisplayName("자동차_Message")
	@ParameterizedTest(name = "{index} - 자동차이름 : {0}")
	@Order(6)
	@CsvSource(value = {"A", "AB", "ABC", "ABCD", "ACBDE", "가", "가나", "가나다", "가나다라", "가나다라마"}, delimiter = ';')
	public void carMessage(String carName) throws IllegalCarNameException {
		Car car = new Car(carName);
		assertThat(car.makeMsg()).isEqualTo(carName + " : ");
		car.calculateDistance(GoStopCode.GO);
		assertThat(car.makeMsg()).isEqualTo(carName + " : -");
		car.calculateDistance(GoStopCode.STOP);
		assertThat(car.makeMsg()).isEqualTo(carName + " : -");
		car.calculateDistance(GoStopCode.GO);
		assertThat(car.makeMsg()).isEqualTo(carName + " : --");
	}
}
