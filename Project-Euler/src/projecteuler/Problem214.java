package projecteuler;

public class Problem214 {

	/**
	 * Calculates the sum of all primes less than 40,000,000 which generate a totient chain of length 25
	 */
	static void solution() {
		long ans = 0;
		int[] phi = Functions.getTotients(40000000);
		for (int p : Functions.getPrimesList(40000000)) {
			int chain = 1;
			int current = p;
			while (current != 1) {
				current = phi[current];
				chain++;
			}
			if (chain == 25)
				ans += p;
		}
		System.out.println(ans);
	}
}