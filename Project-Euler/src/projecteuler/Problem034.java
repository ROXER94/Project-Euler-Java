package projecteuler;

public class Problem034 {

	/**
	 * Calculates the sum of factorions greater than two
	 */
	static void solution() {
		int ans = 0;
		for (int i = 10; i < 50000; i++) {
			int currentFactorialSum = 0;
			for (char c : new Integer(i).toString().toCharArray())
				currentFactorialSum += Functions.getFactorial(c - '0').intValue();
			if (currentFactorialSum == i)
				ans += i;
		}
		System.out.println(ans);
	}
}