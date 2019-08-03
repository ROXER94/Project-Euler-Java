package projecteuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem110 {

	/**
	 * Calculates the least value of n for which the number of distinct solutions of the equation x^-1 + y^-1 = n^-1 exceeds 4,000,000
	 */
	static void solution() {
		long ans = 1;
		int A = 0;
		int B = 0;
		int C = 0;
		int D = 0;
		int E = 0;
		int n = 8000000;
		List<Integer> primes = Functions.getPrimesList(50).subList(0, (int) Math.log(n));
		long limit = 1;
		for (int p : primes)
			limit *= p;
		for (int a = 0; a < 10; a++) {
			if (Math.pow(3, a) > limit)
				break;
			for (int b = 0; b < 5; b++) {
				if (Math.pow(3, a) * Math.pow(5, b) > limit)
					break;
				for (int c = 0; c < 5; c++) {
					if (Math.pow(3, a) * Math.pow(5, b) * Math.pow(7, c) > limit)
						break;
					for (int d = 0; d < 5; d++) {
						if (Math.pow(3, a) * Math.pow(5, b) * Math.pow(7, c) * Math.pow(9, d) > limit)
							break;
						for (int e = 0; e < 5; e++) {
							long currentValue = (long) (Math.pow(3, a) * Math.pow(5, b) * Math.pow(7, c) * Math.pow(9, d) * Math.pow(11, e));
							if (currentValue > limit)
								break;
							else if (currentValue > n) {
								limit = currentValue;
								A = a;
								B = b;
								C = c;
								D = d;
								E = e;
							}
						}
					}
				}
			}
		}
		List<Integer> values = new ArrayList<Integer>(Arrays.asList(E, D, C, B, A));
		while (values.contains(0))
			values.remove(new Integer(0));
		List<Integer> exponents = new ArrayList<Integer>(Arrays.asList(5, 4, 3, 2, 1));
		for (int i = 0; i < 5 - values.size(); i++)
			exponents.remove(0);
		int index = 0;
		for (int i : values) {
			for (int j : primes.subList(0, i))
				ans *= (long) Math.pow(j, exponents.get(index));
			primes = primes.subList(i, primes.size());
			index++;
		}
		System.out.println(ans);
	}
}