package projecteuler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem191 {

	/**
	 * HashMap used to memoize the prize strings
	 */
	static Map<List<Integer>, Integer> prizeStringDict = new HashMap<List<Integer>, Integer>();

	/**
	 * @param late
	 * @param absences
	 * @param day
	 * @return the number of prize strings that exist over a 30-day period
	 */
	static int getPrizeStringCount(int late, int absences, int day) {
		if (day == 30)
			return 1;
		if (late == 1) {
			if (absences == 2) {
				List<Integer> T1 = Functions.getTuple(late, absences, day);
				if (!prizeStringDict.containsKey(T1))
					prizeStringDict.put(T1, getPrizeStringCount(late, 0, day + 1));
				return prizeStringDict.get(T1);
			} else {
				List<Integer> T1 = Functions.getTuple(late, 0, day + 1);
				if (!prizeStringDict.containsKey(T1))
					prizeStringDict.put(T1, getPrizeStringCount(late, 0, day + 1));
				List<Integer> T2 = Functions.getTuple(late, absences + 1, day + 1);
				if (!prizeStringDict.containsKey(T2))
					prizeStringDict.put(T2, getPrizeStringCount(late, absences + 1, day + 1));
				return prizeStringDict.get(T1) + prizeStringDict.get(T2);
			}
		} else {
			if (absences == 2) {
				List<Integer> T1 = Functions.getTuple(late, 0, day + 1);
				if (!prizeStringDict.containsKey(T1))
					prizeStringDict.put(T1, getPrizeStringCount(late, 0, day + 1));
				List<Integer> T2 = Functions.getTuple(late * -1, 0, day + 1);
				if (!prizeStringDict.containsKey(T2))
					prizeStringDict.put(T2, getPrizeStringCount(late * -1, 0, day + 1));
				return prizeStringDict.get(T1) + prizeStringDict.get(T2);
			} else {
				List<Integer> T1 = Functions.getTuple(late, 0, day + 1);
				if (!prizeStringDict.containsKey(T1))
					prizeStringDict.put(T1, getPrizeStringCount(late, 0, day + 1));
				List<Integer> T2 = Functions.getTuple(late, absences + 1, day + 1);
				if (!prizeStringDict.containsKey(T2))
					prizeStringDict.put(T2, getPrizeStringCount(late, absences + 1, day + 1));
				List<Integer> T3 = Functions.getTuple(late * -1, 0, day + 1);
				if (!prizeStringDict.containsKey(T3))
					prizeStringDict.put(T3, getPrizeStringCount(late * -1, 0, day + 1));
				return prizeStringDict.get(T1) + prizeStringDict.get(T2) + prizeStringDict.get(T3);
			}
		}
	}

	/**
	 * Calculates the number of prize strings that exist over a 30-day period
	 */
	static void solution() {
		System.out.println(getPrizeStringCount(-1, 0, 0));
	}
}