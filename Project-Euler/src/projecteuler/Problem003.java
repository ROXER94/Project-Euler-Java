package projecteuler;

import java.util.List;

public class Problem003 {

	/**
	 * Calculates the largest prime factor of 600,851,475,143
	 */
	static void solution() {
		List<Long> primeFactors = Functions.getPrimeFactors(600851475143L);
		System.out.println(primeFactors.get(primeFactors.size() - 1));
	}
}