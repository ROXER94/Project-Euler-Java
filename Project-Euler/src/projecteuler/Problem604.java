package projecteuler;

public class Problem604 {

	/**
	 * Calculates the maximum number of lattice points in an axis-aligned N×N square that the graph of a single strictly convex increasing function can pass
	 * through for N = 10^18
	 */
	static void solution() {
		long ans = 0;
		long n = (long) Math.pow(10, 18);
		int k = (int) Math.pow(n * Math.pow(Math.PI, 2), 1.0 / 3);
		int[] phi = Functions.getTotients(k);
		for (int i = 1; i < k; i++) {
			n -= (long) i * phi[i] / 2;
			ans += phi[i];
		}
		ans += 2 * n / k;
		System.out.println(ans);
	}
}