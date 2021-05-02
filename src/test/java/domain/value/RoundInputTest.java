package domain.value;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import exception.IllegalRoundInputException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RoundInputTest {

	@DisplayName("라운드_숫자_반환")
	@ParameterizedTest(name = "{index} - 입력값 : {0}")
	@Order(1)
	@CsvSource(value = {"1;1", "5;5", "10;10", "99999999;99999999"}, delimiter = ';')
	public void generateRoundInput(String input, int expectedValue) throws IllegalRoundInputException {
		RoundInput actualValue = RoundInput.generate(input);
		assertThat(actualValue.getRound()).isEqualTo(expectedValue);
	}

	@DisplayName("라운드_숫자_반환_실패_1보다_작은_숫자")
	@ParameterizedTest(name = "{index} - 입력값 : {0}")
	@Order(2)
	@CsvSource(value = {"-99999999", "-1", "0"}, delimiter = ';')
	public void generateRoundInputFail(String input) {
		assertThatThrownBy(() -> RoundInput.generate(input)).isInstanceOf(IllegalRoundInputException.class);
	}

	@DisplayName("라운드_숫자_반환_실패_문자")
	@ParameterizedTest(name = "{index} - 입력값 : {0}")
	@Order(3)
	@CsvSource(value = {"ABCDEFG", "가나다라마바사", "a1s2d3f4"}, delimiter = ';')
	public void generateRoundInputFailWithCharacter(String input) {
		assertThatThrownBy(() -> RoundInput.generate(input)).isInstanceOf(NumberFormatException.class);
	}
}
