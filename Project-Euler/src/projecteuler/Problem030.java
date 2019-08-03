package projecteuler;

public class Problem030 {

	/**
	 * Calculates the sum of all the numbers that can be written as the sum of fifth powers of their digits
	 */
	static void solution() {
		int ans = 0;
		for (int i = 2; i < 6 * Math.pow(9, 5); i++) {
			int currentSum = 0;
			for (char c : new Integer(i).toString().toCharArray())
				currentSum += Math.pow(c - '0', 5);
			if (currentSum == i)
				ans += i;
		}
		System.out.println(ans);
	}
}