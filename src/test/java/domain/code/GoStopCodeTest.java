package domain.code;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import exception.IllegalRandomIntegerValueException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GoStopCodeTest {

	@DisplayName("GO_확인")
	@Test
	@Order(1)
	public void checkGo() {
		GoStopCode inputCode = GoStopCode.GO;
		assertThat(inputCode.isGo()).isEqualTo(true);
	}

	@DisplayName("STOP_확인")
	@Test
	@Order(2)
	public void checkStop() {
		GoStopCode inputCode = GoStopCode.STOP;
		assertThat(inputCode.isStop()).isEqualTo(true);
	}

	@DisplayName("GO_판별")
	@ParameterizedTest(name = "{index} - 랜덤값 : {0}, 예상결과 : {1}")
	@Order(3)
	@CsvSource(value = {"3;false", "4;true", "5;true", "6;true", "7;true", "8;true", "9;true"}, delimiter = ';')
	public void distinguishGo(int num, boolean expectedResult) throws IllegalRandomIntegerValueException {
		GoStopCode result = GoStopCode.distinguishGoStop(num);
		assertThat(result.isGo()).isEqualTo(expectedResult);
	}

	@DisplayName("STOP_판별")
	@ParameterizedTest(name = "{index} - 랜덤값 : {0}, 예상결과 : {1}")
	@Order(4)
	@CsvSource(value = {"0;true", "1;true", "2;true", "3;true", "4;false"}, delimiter = ';')
	public void distinguishStop(int num, boolean expectedResult) throws IllegalRandomIntegerValueException {
		GoStopCode result = GoStopCode.distinguishGoStop(num);
		assertThat(result.isStop()).isEqualTo(expectedResult);
	}

	@DisplayName("GO_STOP_판별할_수_없는_값")
	@ParameterizedTest(name = "{index} - 랜덤값 : {0}")
	@Order(5)
	@CsvSource(value = {"-1", "10"}, delimiter = ';')
	public void notDistinguishGoAndStop(int num) {
		assertThatThrownBy(() -> GoStopCode.distinguishGoStop(num))
			.isInstanceOf(IllegalRandomIntegerValueException.class);
	}

	@DisplayName("난수값_생성_0부터_9까지")
	@ParameterizedTest(name = "{index} - 최하값 : {0}, 최대값 : {1}")
	@Order(6)
	@CsvSource(value = {"0;9;true", "-99999;-1;false", "10;99999;false"}, delimiter = ';')
	public void randomValuefrom0To9(int minNum, int maxNum, boolean expectedResult) {
		for (int i = 0; i < 10; i++) {
			int randomNum = GoStopCode.randomInteger0To9();
			boolean actualResult = minNum <= randomNum && randomNum <= maxNum;
			assertThat(actualResult).isEqualTo(expectedResult);
		}
	}
}
