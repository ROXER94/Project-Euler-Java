package projecteuler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem548 {

	/**
	 * @param n
	 * @return the number of gozinta chains
	 */
	static BigInteger getGozinta(long[] n) {
		List<Long> O = new ArrayList<Long>();
		if (n.length == 1)
			for (int i : Functions.getOmega(n[0]).values())
				O.add((long) i);
		else
			for (long i : n)
				O.add(i);
		BigInteger S = BigInteger.ZERO;
		for (int i = 1; i <= Functions.getLongListSum(O); i++)
			for (int j = 0; j < i; j++) {
				BigInteger K = BigInteger.ONE;
				for (int k = 0; k < O.size(); k++)
					K = K.multiply(Functions.getnCk(O.get(k).intValue() + i - j - 1, O.get(k).intValue()));
				S = S.add(BigInteger.valueOf(-1).pow(j).multiply(Functions.getnCk(i, j)).multiply(K));
			}
		return S;
	}

	/**
	 * Calculates the sum of the numbers n not exceeding 10^16 for which g(n) = n
	 */
	static void solution() {
		long ans = 1;
		Set<Long> gozintaChain = new HashSet<Long>();
		for (int a = 1; a < 45; a++)
			for (int b = 1; b < 5; b++)
				for (int c = 0; c < 2; c++)
					for (int d = c; d < 2; d++)
						for (int e = d; e < 2; e++)
							for (int f = e; f < 2; f++) {
								BigInteger n = getGozinta(new long[] { a, b, c, d, e, f });
								if (n.compareTo(BigInteger.valueOf(10).pow(16)) < 0 && getGozinta(new long[] { n.longValue() }).equals(n))
									gozintaChain.add(n.longValue());
							}
		for (long i : gozintaChain)
			ans += i;
		System.out.println(ans);
	}
}