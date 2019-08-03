package projecteuler;

import java.util.ArrayList;
import java.util.List;

public class Problem037 {

	/**
	 * @param n
	 * @return List of left-truncated results
	 */
	static List<Integer> getTruncateLeft(int n) {
		List<Integer> list = new ArrayList<Integer>();
		String s = new Integer(n).toString();
		while (s.length() > 0) {
			list.add(Integer.parseInt(s));
			s = s.substring(1);
		}
		return list;
	}

	/**
	 * @param n
	 * @return List of right-truncated results
	 */
	static List<Integer> getTruncateRight(int n) {

		List<Integer> list = new ArrayList<Integer>();
		String s = new Integer(n).toString();
		while (s.length() > 0) {
			list.add(Integer.parseInt(s));
			s = s.substring(0, s.length() - 1);
		}
		return list;
	}

	/**
	 * Calculates the sum of every two-sided truncatable prime
	 */
	static void solution() {
		int ans = 0;
		List<Integer> primes = Functions.getPrimesList(750000);
		for (int i = 0; i <= 3; i++)
			primes.remove(0);
		for (int p : primes) {
			boolean b = true;
			List<Integer> truncatablePrimes = getTruncateLeft(p);
			truncatablePrimes.addAll(getTruncateRight(p));
			for (int i : truncatablePrimes) {
				if (Functions.isPrime(i))
					continue;
				else {
					b = false;
					break;
				}
			}
			if (b)
				ans += p;
		}
		System.out.println(ans);
	}
}