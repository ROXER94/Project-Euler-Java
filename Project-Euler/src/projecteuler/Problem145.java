package projecteuler;

public class Problem145 {

	/**
	 * @param n
	 * @return True if n is reversible
	 */
	static boolean isReversible(int n) {
		String s = new Integer(n).toString();
		if (s.charAt(s.length() - 1) == '0')
			return false;
		String test = new Integer(n + Integer.parseInt(new StringBuilder(s).reverse().toString())).toString();
		if (test.contains("0") || test.contains("2") || test.contains("4") || test.contains("6") || test.contains("8"))
			return false;
		return true;
	}

	/**
	 * Calculates the number of reversible numbers below 1,000,000,000
	 */
	static void solution() {
		int ans = 0;
		for (int i = 1; i < 1000000000; i++)
			if (isReversible(i))
				ans++;
		System.out.println(ans);
	}
}