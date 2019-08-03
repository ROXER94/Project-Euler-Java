package projecteuler;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

public class Problem026 {

	/**
	 * Calculates the number below 1000 which contains the longest recurring cycle in its decimal fraction part
	 */
	static void solution() {
		List<Integer> primes = Functions.getPrimesList(1000);
		Collections.reverse(primes);
		for (int ans : primes) {
			int t = 1;
			while (!BigInteger.valueOf(10).modPow(BigInteger.valueOf(t), BigInteger.valueOf(ans)).equals(BigInteger.ONE)) {
				t++;
			}
			if (t == ans - 1) {
				System.out.println(ans);
				break;
			}
		}
	}
}