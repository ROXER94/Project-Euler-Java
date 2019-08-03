package projecteuler;

public class Problem301 {

	/**
	 * Calculates the number of positive integers n ≤ 2^30 for which X(n,2n,3n) = 0
	 */
	static void solution() {
		int ans = 0;
		for (int i = 1; i <= Math.pow(2, 30); i++)
			if ((i ^ 2 * i ^ 3 * i) == 0)
				ans++;
		System.out.println(ans);
	}
}