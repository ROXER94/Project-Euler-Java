package projecteuler;

public class Problem038 {

	/**
	 * @param n
	 * @return the pandigital concatenated product of n
	 */
	static int getPandigitalProduct(int n) {
		String s = "";
		int i = 1;
		while (s.length() < 10) {
			s += new Integer(n * i).toString();
			i++;
		}
		s = s.substring(0, 9);
		if (s.chars().distinct().count() == 9 && !s.contains("0"))
			return Integer.parseInt(s);
		return 0;
	}

	/**
	 * Calculates the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2,...,n) where n > 1
	 */
	static void solution() {
		int ans = 0;
		for (int i = 9999; i >= 9000; i--)
			ans = Math.max(ans, getPandigitalProduct(i));
		System.out.println(ans);
	}
}