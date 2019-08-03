package projecteuler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Problem076 {

	/**
	 * Dictionary used in the Partition Function
	 */
	static Map<Integer, Long> partitionDict = new HashMap<Integer, Long>();

	/**
	 * @param n
	 * @return the number of partitions of n
	 */
	static long getPartition(int n) {
		if (!partitionDict.containsKey(n)) {
			long partition = 0;
			for (int k = 0; k < n; k++)
				partition += Functions.getLongListSum(new ArrayList<Long>(Functions.getFactors(n - k))) * getPartition(k);
			partitionDict.put(n, partition / n);
		}
		return partitionDict.get(n);
	}

	/**
	 * 
	 */
	static void solution() {
		partitionDict.put(0, 1L);
		System.out.println(getPartition(100) - 1);
	}
}