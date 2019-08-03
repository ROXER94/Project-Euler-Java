package projecteuler;

import java.math.BigInteger;

public class Problem066 {

	/**
	 * Calculates the value of D ≤ 1000 in minimal solutions of x for which the largest value of x is obtained
	 */
	static void solution() {
		long ans = 0;
		BigInteger minimumSolutions = BigInteger.ZERO;
		for (long i = 1; i <= 1000; i++)
			if (!Functions.isSquare(i)) {
				BigInteger currentSolutions = Functions.getPellSolution(i).get(0);
				if (currentSolutions.compareTo(minimumSolutions) > 0) {
					minimumSolutions = currentSolutions;
					ans = i;
				}
			}
		System.out.println(ans);
	}
}