package projecteuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Problem044 {

	/**
	 * Calculates the minimum difference of two pentagonal numbers whose sum and difference are pentagonal
	 */
	static void solution() {
		HashSet<Long> pentagon = new HashSet<Long>();
		List<List<Long>> pairs = new ArrayList<List<Long>>();
		for (int i = 1; i < 2500; i++)
			pentagon.add(Functions.getPentagon(i));
		Long[] pentagonArray = pentagon.toArray(new Long[pentagon.size()]);
		Arrays.sort(pentagonArray);
		for (int i = 0; i < pentagon.size() - 1; i++)
			for (int j = i; j < pentagon.size() - 1; j++)
				if (pentagon.contains(pentagonArray[i] + pentagonArray[j]))
					pairs.add(Functions.getTuple(pentagonArray[i], pentagonArray[j]));
		for (List<Long> i : pairs)
			if (pentagon.contains(i.get(1) - i.get(0)))
				System.out.println(i.get(1) - i.get(0));
	}
}