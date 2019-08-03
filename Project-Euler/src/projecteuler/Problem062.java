package projecteuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem062 {

	/**
	 * @param permutationsDict
	 * @param n
	 * @return the first key in permutationsDict with value n
	 */
	static String getSpecificDictionaryKey(Map<String, Integer> permutationsDict, int n) {
		Object[] values = permutationsDict.values().toArray();
		Object[] keys = permutationsDict.keySet().toArray();
		return (String) keys[Arrays.asList(values).indexOf(n)];
	}

	/**
	 * Calculates the smallest cube for which exactly five permutations of its digits are cube
	 */
	static void solution() {
		List<Long> cubes = new ArrayList<Long>();
		for (long i = 1; i <= 8400; i++)
			cubes.add(i * i * i);
		Map<String, Integer> cubePermutationsDict = new HashMap<String, Integer>();
		List<String> C = new ArrayList<String>();
		for (long cube : cubes)
			C.add(Functions.getSortedString(new Long(cube).toString()));
		for (String s : C)
			cubePermutationsDict.merge(s, 1, Integer::sum);
		for (long ans : cubes) {
			char[] charArray = new Long(ans).toString().toCharArray();
			Arrays.sort(charArray);
			if (new String(charArray).equals(getSpecificDictionaryKey(cubePermutationsDict, 5))) {
				System.out.println(ans);
				break;
			}
		}
	}
}