package projecteuler;

public class Problem112 {

	/**
	 * @param n
	 * @return True if n is increasing
	 */
	static boolean isIncreasing(int n) {
		String s = new Integer(n).toString();
		for (int i = 0; i < s.length() - 1; i++)
			if (s.charAt(i) - '0' > s.charAt(i + 1) - '0')
				return false;
		return true;
	}

	/**
	 * @param n
	 * @return True if n is decreasing
	 */
	static boolean isDecreasing(int n) {
		String s = new Integer(n).toString();
		for (int i = 0; i < s.length() - 1; i++)
			if (s.charAt(i) - '0' < s.charAt(i + 1) - '0')
				return false;
		return true;
	}

	/**
	 * @param n
	 * @return True if n is bouncy
	 */
	static boolean isBouncy(int n) {
		return !isIncreasing(n) && !isDecreasing(n);
	}

	/**
	 * Calculates the least number for which the proportion of bouncy numbers is exactly 99%
	 */
	static void solution() {
		int ans = 1000;
		double bouncyCount = 525;
		while (bouncyCount / ans != .99) {
			ans++;
			if (isBouncy(ans))
				bouncyCount++;
		}
		System.out.println(ans);
	}
}