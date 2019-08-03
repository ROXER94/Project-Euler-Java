package projecteuler;

public class Problem211 {

	/**
	 * Calculates the sum of all positive numbers n below 64,000,000 such that σ2(n) is a perfect square
	 */
	static void solution() {
		long ans = 1;
		int n = 64000000;
		long[] o2 = new long[n];
		for (int i = 0; i < n; i++)
			o2[i] = 1;
		for (long i = 2; i < n; i++) {
			for (long j = i; j < n; j += i)
				o2[(int) j] += i * i;
			if (Functions.isSquare(o2[(int) i]))
				ans += i;
		}
		System.out.println(ans);
	}
}