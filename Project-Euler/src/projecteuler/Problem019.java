package projecteuler;

import java.util.Calendar;

public class Problem019 {

	/**
	 * Calculates the number of Sundays that fell on the first of the month between January 1st, 1901 and December 31st, 2000
	 */
	static void solution() {
		int ans = 0;
		Calendar calendar = Calendar.getInstance();
		for (int y = 1901; y <= 2000; y++)
			for (int m = 1; m <= 12; m++) {
				calendar.set(y, m, 1);
				if (calendar.get(Calendar.DAY_OF_WEEK) == 1)
					ans++;
			}
		System.out.println(ans);
	}
}