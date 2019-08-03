package projecteuler;

public class Problem006 {

	/**
	 * Calculates the difference between the sum of the squares of the first one hundred numbers and the square of the sum
	 */
	static void solution() {
		int n = 100;
		System.out.println((int) Math.pow(n * (n + 1) / 2, 2) - (n * (n + 1) * (2 * n + 1) / 6));
	}
}