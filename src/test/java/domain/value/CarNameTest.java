package domain.value;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import exception.IllegalCarNameException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarNameTest {

	@Test
	@Order(1)
	public void 자동차_이름_0자() {
		assertThatThrownBy(() -> CarName.generate("")).isInstanceOf(IllegalCarNameException.class);
	}

	@ParameterizedTest(name = "{index} - 자동차이름 : {0}")
	@Order(2)
	@CsvSource(value = {"A", "AB", "ABC", "ABCD", "ACBDE", "가", "가나", "가나다", "가나다라", "가나다라마"}, delimiter = ';')
	public void 자동차_이름_1_5자(String carName) throws IllegalCarNameException {
		assertThat(CarName.generate(carName).getName()).isEqualTo(carName);
	}

	@ParameterizedTest(name = "{index} - 자동차이름 : {0}")
	@Order(3)
	@CsvSource(value = {"String", "한글여섯글자"}, delimiter = ';')
	public void 자동차_이름_6자_이상(String carName) {
		assertThatThrownBy(() -> CarName.generate(carName)).isInstanceOf(IllegalCarNameException.class);
	}

	@Test
	@Order(4)
	public void 자동차_이름_NULL() {
		assertThatThrownBy(() -> CarName.generate(null)).isInstanceOf(IllegalCarNameException.class);
	}

}
