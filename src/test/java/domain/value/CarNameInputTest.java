package domain.value;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import exception.IllegalCarNameException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarNameInputTest {

	@DisplayName("자동차_이름_입력값_배열로_반환")
	@ParameterizedTest(name = "{index} - 입력값 : {0}, 배열 예상 길이 : {1}")
	@Order(1)
	@CsvSource(value = {"A,AB,ABC,ABCD,ACBDE;5", "A,AB,ABC,ABCD,ACBDE,가,가나,가나다,가나다라,가나다라마;10"}, delimiter = ';')
	public void validateInput(String input, int size) throws IllegalCarNameException {
		CarNameInput carNameInput = CarNameInput.generate(input);
		assertThat(carNameInput.getCarNames().length).isEqualTo(size);
	}

	@DisplayName("자동차_이름_입력값_배열로_반환_실패")
	@ParameterizedTest(name = "{index} - 입력값 : {0}")
	@Order(2)
	@CsvSource(value = {",A,AB,ABC,ABCD,ACBDE", "A,AB,ABC,ABCD,ACBDE,ABCDEF", ",가,가나,가나다,가나다라,가나다라마",
		"가,가나,가나다,가나다라,가나다라마,가나다라마바", "가|가나|가나다|가나다라|가나다라마|가나다라마바"}, delimiter = ';')
	public void validateInputResultFail(String input) {
		assertThatThrownBy(() -> CarNameInput.generate(input)).isInstanceOf(IllegalCarNameException.class);
	}
}
