package projecteuler;

public class Problem002 {

	/**
	 * Calculates the sum of the even terms of the Fibonacci sequence under 4,000,000
	 */
	static void solution() {
		int ans = 0;
		int a = 1;
		int b = 2;
		while (b < 4000000) {
			int temp = b;
			b = a + b;
			a = temp;
			if (a % 2 == 0)
				ans += a;
		}
		System.out.println(ans);
	}
}