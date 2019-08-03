package projecteuler;

import java.util.HashMap;
import java.util.Map;

public class Problem092 {

	/**
	 * Dictionary used to memoize the Happy numbers
	 */
	static Map<Integer, Boolean> happyDict = new HashMap<Integer, Boolean>();

	/**
	 * @param n
	 * @return True if n is a happy number via memoization
	 */
	static boolean isHappy(int n) {
		if (!happyDict.containsKey(n))
			happyDict.put(n, isHappyUncached(n));
		return happyDict.get(n);
	}

	/**
	 * @param n
	 * @return True if n is a happy number via recursion
	 */
	static boolean isHappyUncached(int n) {
		int s = 0;
		for (char c : new Integer(n).toString().toCharArray())
			s += Math.pow(c - '0', 2);
		if (s == 1)
			return true;
		else if (s == 89)
			return false;
		else
			return isHappy(s);
	}

	/**
	 * Calculates the number of unhappy numbers below 10,000,000
	 */
	static void solution() {
		int ans = 0;
		for (int i = 1; i < 10000000; i++)
			if (!isHappy(i))
				ans++;
		System.out.println(ans);
	}
}