package projecteuler;

public class Problem206 {

	/**
	 * @param n
	 * @return True if n has the form 1_2_3_4_5_6_7_8_9_0
	 */
	static boolean isConcealed(long n) {
		String s = new Long(n).toString();
		return s.charAt(0) == '1' && s.charAt(2) == '2' && s.charAt(4) == '3' && s.charAt(6) == '4' && s.charAt(8) == '5' && s.charAt(10) == '6'
				&& s.charAt(12) == '7' && s.charAt(14) == '8' && s.charAt(16) == '9' && s.charAt(18) == '0';
	}

	/**
	 * Calculates the only positive integer whose square has the form 1_2_3_4_5_6_7_8_9_0
	 */
	static void solution() {
		long ans = (long) (Math.pow(10, 9) + Math.pow(10, 7) + Math.pow(10, 5) + Math.pow(10, 3) + Math.pow(10, 1) + 20);
		boolean b = true;
		while (!isConcealed(ans * ans)) {
			if (b)
				ans += 40;
			else
				ans += 60;
			b = !b;
		}
		System.out.println(ans);
	}
}