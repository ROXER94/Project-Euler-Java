package projecteuler;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem175 {

	static List<BigDecimal> getContinuedFraction(List<BigDecimal> fraction, List<BigDecimal> res) {
		int i = fraction.get(0).divide(fraction.get(1), MathContext.DECIMAL128).intValue();
		BigDecimal f = fraction.get(0).divide(fraction.get(1), MathContext.DECIMAL128).subtract(BigDecimal.valueOf(i));
		res.add(BigDecimal.valueOf(i));
		if (f.setScale(10, RoundingMode.HALF_EVEN).compareTo(BigDecimal.ONE) == 0)
			return res;
		return getContinuedFraction(Functions.getTuple(BigDecimal.ONE, f), res);
	}

	/**
	 * Calculates the Shortened Binary Expansion of the smallest n for which f(n)/f(n-1) = 123456789/987654321
	 */
	static void solution() {
		List<BigDecimal> ans = getContinuedFraction(Functions.getTuple(BigDecimal.valueOf(123456789), BigDecimal.valueOf(987654321)), new ArrayList<BigDecimal>());
		ans.remove(0);
		if (ans.size() % 2 == 0)
			ans.add(BigDecimal.ONE);
		Collections.reverse(ans);
		System.out.println(ans.toString().replaceAll("\\[|\\]|\\s", ""));
	}
}