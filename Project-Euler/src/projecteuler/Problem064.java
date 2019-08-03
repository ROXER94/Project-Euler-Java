package projecteuler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem064 {

	/**
	 * Calculates the number of continued fractions for N ≤ 10,000 that have an odd period
	 */
	static void solution() {
		Set<String> ans = new HashSet<String>();
		for (int i = 1; i <= 10000; i++) {
			if (!Functions.isSquare(i)) {
				List<Integer> CFrepresentation = new ArrayList<Integer>();
				int residue = (int) Math.pow(i, .5);
				double denominator = residue;
				double numerator = i - Math.pow(denominator, 2);
				while (true) {
					int sequenceNumber = (int) ((residue + denominator) / numerator);
					CFrepresentation.add(sequenceNumber);
					double newDenominator = sequenceNumber * numerator - denominator;
					double newNumerator = (i - Math.pow(newDenominator, 2)) / numerator;
					denominator = newDenominator;
					numerator = newNumerator;
					if (newNumerator == 1)
						break;
				}
				CFrepresentation.add(2 * residue);
				if (CFrepresentation.size() == 2 && CFrepresentation.indexOf(0) == CFrepresentation.indexOf(1))
					CFrepresentation.remove(0);
				if (CFrepresentation.size() % 2 != 0)
					ans.add(CFrepresentation.toString().replaceAll(", ", ""));
			}
		}
		System.out.println(ans.size());
	}
}