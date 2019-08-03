package projecteuler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Problem095 {

	/**
	 * @param n
	 * @return the smallest member of an Amicable Chain
	 */
	static int getMinAmicableChain(int n) {
		Set<Integer> hs = new HashSet<Integer>();
		while (!hs.contains(n)) {
			hs.add(n);
			n = (int) (Functions.getLongListSum(new ArrayList<Long>(Functions.getFactors(n))) - n);
		}
		return Collections.min(hs);
	}

	/**
	 * Calculates the smallest member of the longest amicable chain with no element exceeding 1,000,000
	 */
	static void solution() {
		SortedSet<Integer> ans = new TreeSet<Integer>();
		int maximumChainCount = 0;
		HashSet<Integer> seen = new HashSet<Integer>();
		for (int i = 2; i < 6000; i += 2)
			if (!seen.contains(i)) {
				int j = i;
				SortedSet<Integer> chain = new TreeSet<Integer>();
				while (!chain.contains(j)) {
					chain.add(j);
					j = (int) (Functions.getLongListSum(new ArrayList<Long>(Functions.getFactors(j))) - j);
					seen.add(j);
					if (j % 2 == 1 || j < 220 || j > 1000000) {
						chain = new TreeSet<Integer>();
						break;
					}
				}
				int currentChainCount = chain.size();
				if (currentChainCount > maximumChainCount) {
					maximumChainCount = currentChainCount;
					ans = chain;
				}
			}
		System.out.println(getMinAmicableChain(ans.last()));
	}
}