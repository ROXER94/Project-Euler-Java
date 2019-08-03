package projecteuler;

import java.util.ArrayList;
import java.util.List;

public class Problem050 {

	/**
	 * Calculates the prime below 1,000,000 that can be written as the sum of the most consecutive primes
	 */
	static void solution() {
		int ans = 0;
		List<Integer> primes = new ArrayList<Integer>();
		List<Integer> primesList = Functions.getPrimesList(1000000);
		for (int p : primesList) {
			if (Functions.getIntListSum(primes) + p < 1000000)
				primes.add(p);
			else
				break;
		}
		int index = 0;
		int maximumCount = 0;
		while (index != primes.size()) {
			int currentSum = 0;
			List<Integer> accumulated = new ArrayList<Integer>();
			for (int i = index; i < primes.size(); i++) {
				currentSum += primes.get(i);
				accumulated.add(currentSum);
			}
			List<Integer> newPrimes = new ArrayList<Integer>();
			for (int i : accumulated)
				if (i % 2 != 0 && i % 5 != 0)
					if (Functions.isPrime(i))
						newPrimes.add(i);
			int currentCount = accumulated.indexOf(newPrimes.get(newPrimes.size() - 1)) + 1;
			if (currentCount > maximumCount) {
				maximumCount = currentCount;
				ans = newPrimes.get(newPrimes.size() - 1);
			}
			index++;
		}
		System.out.println(ans);
	}
}