package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RacingCarIO {
	private InputStreamReader inputStreamReader = new InputStreamReader(System.in);
	private BufferedReader bufferedReader = new BufferedReader(this.inputStreamReader);

	public String readLineFromSystemIn() throws IOException {
		return this.bufferedReader.readLine().trim();
	}
}
