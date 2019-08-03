package projecteuler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem049 {

	/**
	 * Calculates a 12-digit number that is formed by concatenating the three terms in a unique sequence
	 */
	static void solution() {
		Set<Integer> primes = new HashSet<Integer>();
		List<Integer> primesList = Functions.getPrimesList(10000);
		for (int p : primesList) {
			if (p > 1000)
				primes.add(p);
		}
		for (int p : primes) {
			if (primes.contains(p + 3330) && primes.contains(p + 6660) && p != 1487) {
				boolean b = true;
				for (char c : new Integer(p).toString().toCharArray()) {
					if (!new Integer(p + 3330).toString().contains("" + c) || !new Integer(p + 6660).toString().contains("" + c)) {
						b = false;
						break;
					}
				}
				if (b) {
					System.out.println(new Integer(p).toString() + new Integer(p + 3330).toString() + new Integer(p + 6660).toString());
					break;
				}
			}
		}
	}
}