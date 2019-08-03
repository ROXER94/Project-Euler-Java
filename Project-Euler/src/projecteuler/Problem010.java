package projecteuler;

public class Problem010 {

	/**
	 * Calculates the sum of all primes below 2,000,000
	 */
	static void solution() {
		System.out.println(Functions.getIntListSum(Functions.getPrimesList(2000000)));
	}
}