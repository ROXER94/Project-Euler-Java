package projecteuler;

public class Problem052 {

	static boolean isPermutedMultiple(int n) {
		String s2 = new Integer(2 * n).toString();
		String s3 = new Integer(3 * n).toString();
		String s4 = new Integer(4 * n).toString();
		String s5 = new Integer(5 * n).toString();
		String s6 = new Integer(6 * n).toString();
		return s2.length() == s3.length() && s3.length() == s4.length() && s4.length() == s5.length() && s5.length() == s6.length()
				&& Functions.isAnagram(s2, s3) && Functions.isAnagram(s3, s4) && Functions.isAnagram(s4, s5) && Functions.isAnagram(s5, s6);
	}

	/**
	 * Calculates the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits
	 */
	static void solution() {
		int ans = 1;
		while (true) {
			if (isPermutedMultiple(ans))
				break;
			ans++;
		}
		System.out.println(ans);
	}
}