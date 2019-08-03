package projecteuler;

public class Problem190 {

	/**
	 * Calculates Σ[Pm] for 2 ≤ m ≤ 15
	 */
	static void solution() {
		int ans = 0;
		for (int m = 2; m <= 15; m++) {
			double P = 1;
			for (int i = 1; i <= m; i++)
				P *= Math.pow(2.0 * i / (m + 1), i);
			ans += P;
		}
		System.out.println(ans);
	}
}