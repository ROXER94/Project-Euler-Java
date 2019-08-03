package projecteuler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Problem046 {

	/**
	 * Calculates the smallest odd composite that cannot be written as the sum of a prime and twice a square
	 */
	static void solution() {
		HashSet<Integer> primes = new HashSet<Integer>();
		primes.add(2);
		HashSet<Integer> composites = new HashSet<Integer>();
		for (int i = 3; i <= 10000; i += 2) {
			if (Functions.isPrime(i))
				primes.add(i);
			else
				composites.add(i);
		}
		List<Integer> doubleSquares = new ArrayList<Integer>();
		for (int i = 1; i <= 70; i++)
			doubleSquares.add(2 * i * i);
		HashSet<Integer> Goldbach = new HashSet<Integer>();
		for (int p : primes)
			for (int ds : doubleSquares)
				if (!Goldbach.contains(p + ds) && (p + ds) % 2 != 0 && !Functions.isPrime(p + ds))
					Goldbach.add(p + ds);
		composites.removeAll(Goldbach);
		System.out.println(composites.toArray()[0]);
	}
}