package projecteuler;

import java.math.BigInteger;
import java.util.Map;

public class Problem130 {

	/**
	 * Calculates the sum of the first 25 composite values of n for which GCD(n, 10) = 1 and n − 1 is divisible by A(n)
	 */
	static void solution() {
		int ans = 0;
		int count = 0;
		int n = 91;
		Map<Integer, Boolean> primesDict = Functions.getPrimesDict(15000);
		while (count < 25) {
			if (Functions.getGCD(n, 10) == 1 && Functions.getGCD(n, 3) == 1) {
				int k = 1;
				while (!BigInteger.valueOf(10).modPow(BigInteger.valueOf(k), BigInteger.valueOf(n)).equals(BigInteger.ONE))
					k++;
				if ((n - 1) % k == 0 && !primesDict.containsKey(n)) {
					StringBuilder s = new StringBuilder();
					for (int i = 0; i < k; i++)
						s.append("1");
					if (new BigInteger(s.toString()).mod(BigInteger.valueOf(n)).equals(BigInteger.ZERO)) {
						ans += n;
						count++;
					}
				}
			}
			n += 2;
		}
		System.out.println(ans);
	}
}