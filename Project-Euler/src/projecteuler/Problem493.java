package projecteuler;

import java.text.DecimalFormat;

public class Problem493 {

	/**
	 * Calculates the expected number of distinct colors in 20 randomly picked balls
	 */
	static void solution() {
		System.out.println(new DecimalFormat("#.#########").format(7 * (1 - Functions.getnCk(60, 20).doubleValue() / Functions.getnCk(70, 20).doubleValue())));
	}
}