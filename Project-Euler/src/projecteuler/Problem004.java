package projecteuler;

public class Problem004 {

	/**
	 * @param n
	 * @return True if n is a three-digit product
	 */
	static boolean isThreeDigitProduct(int n) {
		for (int i = 100; i <= 999; i++)
			if (n % i == 0 && String.valueOf(n / i).length() == 3)
				return true;
		return false;
	}

	/**
	 * Calculates the largest palindrome made from the product of two 3-digit numbers
	 */
	static void solution() {
		for (int ans = 999 * 999; ans >= 100 * 100; ans--)
			if (Functions.isPalindrome(String.valueOf(ans)) && isThreeDigitProduct(ans)) {
				System.out.println(ans);
				break;
			}
	}
}