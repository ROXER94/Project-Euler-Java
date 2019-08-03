package projecteuler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem293 {

	/**
	 * List used to store the admissable numbers
	 */
	static List<Integer> admissable = new ArrayList<Integer>();

	/**
	 * @param index
	 * @param product
	 * @param limit
	 * @param primes
	 */
	static void getAdmissable(int index, long product, int limit, List<Integer> primes) {
		if (index == primes.size())
			return;
		while (product <= limit) {
			product *= primes.get(index);
			if (product < limit)
				admissable.add((int) product);
			getAdmissable(index + 1, product, limit, primes);
		}
	}

	/**
	 * Calculates the sum of all distinct pseudo-Fortunate numbers for admissible numbers less than 10^9
	 */
	static void solution() {
		int ans = 0;
		Set<Integer> pseudoFortunate = new HashSet<Integer>();
		getAdmissable(0, 1L, 1000000000, Functions.getPrimesList(24));
		for (int i : admissable) {
			int j = 3;
			while (true) {
				if (Functions.isPrime(i + j))
					break;
				j += 2;
			}
			pseudoFortunate.add(j);
		}
		for (int i : pseudoFortunate)
			ans += i;
		System.out.println(ans);
	}
}