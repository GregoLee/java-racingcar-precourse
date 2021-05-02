package domain.value;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CarDistanceTest {

	@Test
	@Order(1)
	public void 자동차가_간_거리_생성() {
		assertThat(CarDistance.generate().length()).isEqualTo(0);
	}

	@Test
	@Order(2)
	public void 자동차가_간_거리_출력() {
		assertThat(CarDistance.generate().makeMsg()).isEqualTo("");
	}

	@Test
	@Order(3)
	public void 자동차_거리_증가() {
		assertThat(CarDistance.generate().increase().makeMsg()).isEqualTo("-");
	}
}
