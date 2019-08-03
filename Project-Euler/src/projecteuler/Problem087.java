package projecteuler;

import java.util.HashSet;
import java.util.Set;

public class Problem087 {

	/**
	 * Calculates the number of numbers below 50,000,000 that can be expressed as the sum of a prime square, prime cube, and prime fourth power
	 */
	static void solution() {
		Set<Long> ans = new HashSet<Long>();
		int limit = 50000000;
		Set<Integer> primes = Functions.ToHashSet(Functions.getPrimesList((int) Math.pow(limit, .5)));
		for (int a = 2; a <= (int) Math.pow(limit, .5); a++)
			if (primes.contains(a))
				for (int b = 2; b <= (int) Math.pow(limit, .3333); b++)
					if (a * a + b * b * b < limit)
						if (primes.contains(b))
							for (int c = 2; c <= (int) Math.pow(limit, .25); c++)
								if (primes.contains(c))
									if (a * a + b * b * b + c * c * c * c < limit)
										ans.add((long) a * a + b * b * b + c * c * c * c);
		System.out.println(ans.size());
	}
}