package projecteuler;

public class Problem040 {

	/**
	 * Calculates the product of the 1st, 10th, 100th, 1000th, 10,000th, 100,000th, and 1,000,000th digits in Champernowne's Constant
	 */
	static void solution() {
		StringBuilder Champernowne = new StringBuilder();
		int n = 1;
		while (Champernowne.length() < 1000000) {
			Champernowne.append(n);
			n++;
		}
		System.out.println((Champernowne.charAt(0) - '0') * (Champernowne.charAt(9) - '0') * (Champernowne.charAt(99) - '0') * (Champernowne.charAt(999) - '0')
				* (Champernowne.charAt(9999) - '0') * (Champernowne.charAt(99999) - '0') * (Champernowne.charAt(999999) - '0'));
	}
}