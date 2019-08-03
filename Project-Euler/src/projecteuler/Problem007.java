package projecteuler;

public class Problem007 {

	/**
	 * Calculates the 10,001st prime number
	 */
	static void solution() {
		System.out.println(Functions.getPrimesList(120000).get(10000));
	}
}