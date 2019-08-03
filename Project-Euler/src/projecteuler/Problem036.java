package projecteuler;

import java.util.ArrayList;
import java.util.List;

public class Problem036 {

	/**
	 * Calculates the sum of numbers under 1,000,000 that are palindromes in both decimal and binary
	 */
	static void solution() {
		int ans = 0;
		List<Integer> palindromes = new ArrayList<Integer>();
		List<String> binary = new ArrayList<String>();
		for (int i = 1; i < 1000000; i++)
			if (Functions.isPalindrome(new Integer(i).toString()))
				palindromes.add(i);
		for (int i : palindromes)
			binary.add(Integer.toBinaryString(i));
		for (String s : binary)
			if (Functions.isPalindrome(s))
				ans += Integer.parseInt(s, 2);
		System.out.println(ans);
	}
}