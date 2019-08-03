package projecteuler;

public class Problem025 {

	/**
	 * Calculates the index of the first term in the Fibonacci sequence to contain 1000 digits
	 */
	static void solution() {
		int ans = 0;
		while (Functions.getFibonacci2(ans).toString().length() < 1000)
			ans++;
		System.out.println(ans);
	}
}