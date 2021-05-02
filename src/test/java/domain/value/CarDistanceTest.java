package domain.value;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarDistanceTest {

	@DisplayName("자동차가_간_거리_생성")
	@Test
	@Order(1)
	public void generateCarDistance() {
		assertThat(CarDistance.generate().length()).isEqualTo(0);
	}

	@DisplayName("자동차가_간_거리_출력")
	@Test
	@Order(2)
	public void makeCarDistance() {
		assertThat(CarDistance.generate().makeMsg()).isEqualTo("");
	}

	@DisplayName("자동차_거리_증가")
	@Test
	@Order(3)
	public void increaseCarDistance() {
		assertThat(CarDistance.generate().increase().makeMsg()).isEqualTo("-");
	}
}
