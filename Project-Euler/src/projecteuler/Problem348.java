package projecteuler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Problem348 {

	/**
	 * Calculates the sum of the five smallest palindromic numbers that are the sum of square and a cube in exactly 4 different ways
	 */
	static void solution() {
		List<Integer> ans = new ArrayList<Integer>();
		Map<Integer, Integer> palindromesDict = new TreeMap<Integer, Integer>();
		for (int i = 2; i < 30000; i++)
			for (int j = 2; j < 1000; j++) {
				int currentValue = i * i + j * j * j;
				if (Functions.isPalindrome(new Long(currentValue).toString()))
					palindromesDict.merge(currentValue, 1, Integer::sum);
			}
		for (int i : palindromesDict.keySet())
			if (palindromesDict.get(i) == 4)
				if (ans.size() <= 5)
					ans.add(i);
				else
					break;
		System.out.println(Functions.getIntListSum(ans));
	}
}