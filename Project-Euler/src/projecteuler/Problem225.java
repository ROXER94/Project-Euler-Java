package projecteuler;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Problem225 {

	/**
	 * HashMap used to memoize the Tribonacci sequence
	 */
	static Map<Integer, BigInteger> TribonacciDict = new HashMap<Integer, BigInteger>();

	/**
	 * @param n
	 * @return the nth Tribonacci number
	 */
	static BigInteger getTribonacci(int n) {
		if (!TribonacciDict.containsKey(n))
			TribonacciDict.put(n, getTribonacci(n - 1).add(getTribonacci(n - 2)).add(getTribonacci(n - 3)));
		return TribonacciDict.get(n);
	}

	/**
	 * Calculates the 124th odd number that does not divide any terms in the Tribonacci sequence
	 */
	static void solution() {
		TribonacciDict.put(1, BigInteger.ONE);
		TribonacciDict.put(2, BigInteger.ONE);
		TribonacciDict.put(3, BigInteger.ONE);
		int count = 0;
		for (int i = 1; i <= 100; i++)
			getTribonacci(230 * i);
		for (int ans = 27; ans < 6669; ans += 2) {
			boolean divide = false;
			for (BigInteger t : TribonacciDict.values()) {
				if (t.mod(BigInteger.valueOf(ans)).equals(BigInteger.ZERO)) {
					divide = true;
					break;
				}
			}
			if (!divide)
				count++;
			if (count == 124) {
				System.out.println(ans);
				break;
			}
		}
	}
}