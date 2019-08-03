package projecteuler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

public class Problem581 {

	/**
	 * @param n
	 * @return Lehmer's speed-up for n
	 */
	static List<BigInteger> getLehmerSpeedUp(BigInteger n) {
		BigInteger x = n.subtract(BigInteger.ONE).divide(BigInteger.valueOf(2));
		BigInteger y = n.add(BigInteger.ONE).divide(BigInteger.valueOf(2));
		if (Functions.isSmooth(x, 47) && Functions.isSmooth(y, 47))
			return Functions.getTuple(BigInteger.ONE, x);
		return Functions.getTuple(BigInteger.ZERO, BigInteger.ZERO);
	}

	/**
	 * @param x0
	 * @param y0
	 * @param D
	 * @param count
	 * @return the next set of solutions of a given Pell's equation
	 */
	static List<List<BigInteger>> getNextPellSolutions(BigInteger x0, BigInteger y0, long D, int count) {
		List<List<BigInteger>> pellSoultions = new ArrayList<List<BigInteger>>();
		BigInteger xCurrent = x0;
		BigInteger yCurrent = y0;
		for (int i = 0; i < count; i++) {
			pellSoultions.add(Functions.getTuple(xCurrent, yCurrent));
			BigInteger xNext = x0.multiply(xCurrent).add(BigInteger.valueOf(D).multiply(y0).multiply(yCurrent));
			BigInteger yNext = y0.multiply(xCurrent).add(x0.multiply(yCurrent));
			xCurrent = xNext;
			yCurrent = yNext;
		}
		return pellSoultions;
	}

	/**
	 * Calculates the sum of indices n such that T(n) is 47-smooth
	 */
	static void solution() {
		BigInteger ans = BigInteger.ZERO;
		List<Integer> primes = Functions.getPrimesList(48);// 48
		SortedSet<Long> squarefrees = Functions.getSquarefrees(1, 0, primes);
		squarefrees.remove(2L);
		for (long sqfree : squarefrees) {
			List<BigInteger> fundamentalSolution = Functions.getPellSolution(2 * sqfree);
			if (getLehmerSpeedUp(fundamentalSolution.get(0)).get(0).equals(BigInteger.ONE))
				for (List<BigInteger> i : getNextPellSolutions(fundamentalSolution.get(0), fundamentalSolution.get(1), 2 * sqfree,
						(int) Math.max(3, (primes.get(primes.size() - 1) + 1) / 2))) {
					List<BigInteger> Lehmer = getLehmerSpeedUp(i.get(0));
					if (Lehmer.get(0).equals(BigInteger.ONE))
						ans = ans.add(Lehmer.get(1));
				}
		}
		System.out.println(ans);
	}
}