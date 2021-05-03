import exception.IllegalRandomIntegerValueException;
import ui.RacingCarUI;

public class RacingCarApplication {
	public static void main(String[] args) {
		try {
			new RacingCarUI().selectDisplay();
		} catch (IllegalRandomIntegerValueException e) {
			System.out.println(e.getMessage());
		}
	}
}
