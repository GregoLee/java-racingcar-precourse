package domain.value;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import exception.IllegalCarNameException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarNameTest {

	@DisplayName("자동차_이름_0자")
	@Test
	@Order(1)
	public void carNameLength0() {
		assertThatThrownBy(() -> CarName.generate("")).isInstanceOf(IllegalCarNameException.class);
	}

	@DisplayName("자동차_이름_1_5자")
	@ParameterizedTest(name = "{index} - 자동차이름 : {0}")
	@Order(2)
	@CsvSource(value = {"A", "AB", "ABC", "ABCD", "ACBDE", "가", "가나", "가나다", "가나다라", "가나다라마"}, delimiter = ';')
	public void carNameFrom1To5(String carName) throws IllegalCarNameException {
		assertThat(CarName.generate(carName).getName()).isEqualTo(carName);
	}

	@DisplayName("자동차_이름_6자_이상")
	@ParameterizedTest(name = "{index} - 자동차이름 : {0}")
	@Order(3)
	@CsvSource(value = {"String", "한글여섯글자"}, delimiter = ';')
	public void carNameOver5(String carName) {
		assertThatThrownBy(() -> CarName.generate(carName)).isInstanceOf(IllegalCarNameException.class);
	}

	@DisplayName("자동차_이름_NULL")
	@Test
	@Order(4)
	public void carNameIsNull() {
		assertThatThrownBy(() -> CarName.generate(null)).isInstanceOf(IllegalCarNameException.class);
	}

}
