package projecteuler;

public class Problem020 {

	/**
	 * Calculates the sum of the digits in 100!
	 */
	static void solution() {
		int ans = 0;
		for (char c : Functions.getFactorial2(100).toString().toCharArray())
			ans += c - '0';
		System.out.println(ans);
	}
}