package domain.aggregate;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import domain.entity.Car;
import exception.IllegalCarNameException;
import exception.IllegalRandomIntegerValueException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarGroupTest {

	private CarGroup preparedCarGroup;

	@BeforeEach
	void setUp() throws IllegalCarNameException {
		this.preparedCarGroup = CarGroup.generate("pobi,crong,honux".split(","));
		List<Car> cars = this.preparedCarGroup.getCars();
		cars.get(0).getDistance().increase().increase().increase().increase().increase();
		cars.get(1).getDistance().increase().increase().increase().increase();
		cars.get(2).getDistance().increase().increase().increase().increase().increase();
	}

	@DisplayName("자동차_그룹_생성")
	@ParameterizedTest(name = "{index} - 자동차이름 : {0}")
	@Order(1)
	@CsvSource(value = {"A,AB,ABC,ABCD,ACBDE;5", "A,AB,ABC,ABCD,ACBDE,가,가나,가나다,가나다라,가나다라마;10"}, delimiter = ';')
	public void generateCarGroup(String carGroupStr, int expectedSize) throws IllegalCarNameException {
		CarGroup carGroup = CarGroup.generate(carGroupStr.split(","));
		assertThat(carGroup.size()).isEqualTo(expectedSize);
	}

	@DisplayName("자동차_그룹_길이_체크")
	@Test
	@Order(2)
	public void checkSizePreparedCarGroup() {
		assertThat(this.preparedCarGroup.size()).isEqualTo(3);
	}

	@DisplayName("자동차_그룹_우승자_찾기")
	@Test
	@Order(3)
	public void findWinnersInPreparedCarGroup() {
		assertThat(this.preparedCarGroup.makeMsgWinners()).isEqualTo("pobi, honux가 최종 우승했습니다.");
	}

	@DisplayName("자동차_그룹_실행결과_메시지_생성")
	@Test
	@Order(4)
	public void makeMsgInRacing() {
		String expectedMsg = "pobi : -----\ncrong : ----\nhonux : -----\n";
		assertThat(this.preparedCarGroup.makeMsgInRacing()).isEqualTo(expectedMsg);
	}

	@DisplayName("자동차_그룹_라운드_5회_실행")
	@ParameterizedTest(name = "{index} - 자동차이름 : {0}")
	@Order(5)
	@CsvSource(value = {"A,AB,ABC,ABCD,ACBDE;5", "A,AB,ABC,ABCD,ACBDE,가,가나,가나다,가나다라,가나다라마;10"}, delimiter = ';')
	public void playRound(String carGroupStr, int rounds) throws
		IllegalCarNameException,
		IllegalRandomIntegerValueException {
		CarGroup carGroup = CarGroup.generate(carGroupStr.split(","));
		for (int i = 0; i < rounds; i++) {
			carGroup.playRound();
			System.out.println(carGroup.makeMsgInRacing());
		}
		System.out.println(carGroup.makeMsgWinners());
	}
}
