package projecteuler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem303 {

	/**
	 * Calculates the sum of the multipliers k for which the least positive multiple n*k, written in base 10, uses only digits ≤ 2, from 1 to 10,000
	 */
	static void solution() {
		long ans = 1;
		List<Long> base3 = new ArrayList<Long>();
		for (int i = 1; i < 25000000; i++)
			base3.add(Long.parseLong(Functions.getConvertBase(new Integer(i).toString(), 10, 3)));
		Map<Integer, Long> multiplesDict = new HashMap<Integer, Long>();
		for (int i = 1; i < 9999; i++) {
			if (!multiplesDict.containsKey(i))
				for (long m : base3)
					if (m % i == 0) {
						multiplesDict.put(i, m);
						break;
					}
			multiplesDict.put(10 * i, 10 * multiplesDict.get(i));
			ans += multiplesDict.get(i) / i;
		}
		ans += new BigInteger("11112222222222222222").divide(BigInteger.valueOf(9999)).longValue();
		System.out.println(ans);
	}
}