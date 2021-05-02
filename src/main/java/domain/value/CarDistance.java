package domain.value;

public class CarDistance {
	private int distance;

	public static CarDistance generate() {
		return new CarDistance();
	}

	public int length() {
		return this.distance;
	}

	public String makeMsg() {
		StringBuilder tempDistance = new StringBuilder();
		for (int i = 0; i < this.distance; i++) {
			tempDistance.append("-");
		}
		return tempDistance.toString();
	}

	public CarDistance increase() {
		this.distance++;
		return this;
	}
}
