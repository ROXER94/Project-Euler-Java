package projecteuler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Problem051 {

	/**
	 * @param str
	 * @return the first maximum occurring character in str
	 */
	static char getMaxOccuringChar(String str) {
		int count[] = new int[256];
		int len = str.length();
		for (int i = 0; i < len; i++)
			count[str.charAt(i)]++;
		int max = -1;
		char result = ' ';
		for (int i = 0; i < len; i++) {
			if (max < count[str.charAt(i)]) {
				max = count[str.charAt(i)];
				result = str.charAt(i);
			}
		}
		return result;
	}

	/**
	 * Calculates the smallest prime in an eight prime value family
	 */
	static void solution() {
		List<Integer> primesList = Functions.getPrimesList(1000000);
		List<Integer> primes = new ArrayList<Integer>();
		for (int i = 9592; i < primesList.size(); i++)
			primes.add(primesList.get(i));
		Map<Integer, Boolean> primesDict = Functions.getPrimesDict(1000000);
		for (int ans : primes) {
			int count = 0;
			char c = getMaxOccuringChar(new Integer(ans).toString());
			String s = new Integer(ans).toString();
			int i = Integer.parseInt(s.replace(c, '0'));
			if (primesDict.containsKey(i) && new Integer(i).toString().length() == 6)
				count++;
			i = Integer.parseInt(s.replace(c, '1'));
			if (primesDict.containsKey(i))
				count++;
			i = Integer.parseInt(s.replace(c, '2'));
			if (primesDict.containsKey(i))
				count++;
			i = Integer.parseInt(s.replace(c, '3'));
			if (primesDict.containsKey(i))
				count++;
			i = Integer.parseInt(s.replace(c, '4'));
			if (primesDict.containsKey(i))
				count++;
			i = Integer.parseInt(s.replace(c, '5'));
			if (primesDict.containsKey(i))
				count++;
			i = Integer.parseInt(s.replace(c, '6'));
			if (primesDict.containsKey(i))
				count++;
			i = Integer.parseInt(s.replace(c, '7'));
			if (primesDict.containsKey(i))
				count++;
			i = Integer.parseInt(s.replace(c, '8'));
			if (primesDict.containsKey(i))
				count++;
			i = Integer.parseInt(s.replace(c, '9'));
			if (primesDict.containsKey(i))
				count++;
			if (count == 8) {
				System.out.println(ans);
				break;
			}
		}
	}
}