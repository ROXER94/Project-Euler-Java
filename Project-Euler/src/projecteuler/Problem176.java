package projecteuler;

import java.util.Collections;
import java.util.List;

public class Problem176 {

	/**
	 * Calculates the smallest integer that can be the length of a cathetus of exactly 47,547 different integer sided right-angled triangles
	 */
	static void solution() {
		long ans = 1;
		int n = 47547;
		List<Integer> primes = Functions.getPrimesList(50);
		List<Long> P = Functions.getPrimeFactors(2 * n + 1);
		Collections.reverse(P);
		for (long p : P.subList(1, P.size()))
			ans *= Math.pow(primes.get(P.indexOf(p)), (p - 1) / 2);
		ans *= Math.pow(2, (P.get(0) + 1) / 2);
		System.out.println(ans);
	}
}