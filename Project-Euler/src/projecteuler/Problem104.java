package projecteuler;

import java.math.BigInteger;

public class Problem104 {

	/**
	 * Calculates the index of the first Fibonacci number for which the first and last nine digits are 1-9 pandigital
	 */
	static void solution() {
		int ans = 1;
		BigInteger a = BigInteger.ZERO;
		BigInteger b = BigInteger.ONE;
		while (true) {
			if (ans % 2 == 0)
				a = a.add(b);
			else
				b = b.add(a);
			if (Functions.isPandigital(a.mod(BigInteger.valueOf(1000000000)).longValue())
					&& Functions.isPandigital(Long.parseLong(a.toString().substring(0, 9))))
				break;
			else
				ans++;
		}
		System.out.println(ans);
	}
}