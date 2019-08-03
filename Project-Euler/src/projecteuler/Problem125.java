package projecteuler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem125 {

	/**
	 * Calculates the sum of all the numbers less than 100,000,000 that are both palindromic and can be written as the sum of consecutive squares
	 */
	static void solution() {
		long ans = 0;
		List<Integer> squares = new ArrayList<Integer>();
		for (int i = 1; i <= 7074; i++)
			squares.add(i * i);
		List<Integer> squarePalindromes = new ArrayList<Integer>();
		for (int i : squares)
			if (Functions.isPalindrome(new Integer(i).toString()))
				squarePalindromes.add(i);
		Set<Integer> palindomes = new HashSet<Integer>();
		int index = 0;
		while (index != squares.size()) {
			int currentValue = 0;
			for (int i : squares.subList(index, squares.size())) {
				if (currentValue + i < 100000000) {
					currentValue += i;
					if (new Integer(currentValue).toString().equals(new StringBuilder(new Integer(currentValue).toString()).reverse().toString()))
						palindomes.add(currentValue);
				}
			}
			index++;
		}
		for (long i : palindomes)
			ans += i;
		for (int i : squarePalindromes)
			ans -= i;
		System.out.println(ans);
	}
}