package projecteuler;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem205 {

	/**
	 * Calculates the probability that Pyramidal Pete beats Cubic Colin
	 */
	static void solution() {
		double ans = 0;
		List<Long> Colin = new ArrayList<Long>();
		for (int a = 1; a < 7; a++)
			for (int b = 1; b < 7; b++)
				for (int c = 1; c < 7; c++)
					for (int d = 1; d < 7; d++)
						for (int e = 1; e < 7; e++)
							for (int f = 1; f < 7; f++)
								Colin.add((long) a + b + c + d + e + f);
		List<Long> Peter = new ArrayList<Long>();
		for (int a = 1; a < 5; a++)
			for (int b = 1; b < 5; b++)
				for (int c = 1; c < 5; c++)
					for (int d = 1; d < 5; d++)
						for (int e = 1; e < 5; e++)
							for (int f = 1; f < 5; f++)
								for (int g = 1; g < 5; g++)
									for (int h = 1; h < 5; h++)
										for (int i = 1; i < 5; i++)
											Peter.add((long) a + b + c + d + e + f + g + h + i);
		Map<Integer, Integer> P = new HashMap<Integer, Integer>();
		Map<Integer, Integer> C = new HashMap<Integer, Integer>();
		for (int i = 6; i <= 36; i++) {
			P.put(i, Functions.getOccurrenceOfValue(Peter, i));
			C.put(i, Functions.getOccurrenceOfValue(Colin, i));
		}
		for (int c = 6; c < 36; c++)
			for (int p = c + 1; p <= 36; p++)
				ans += C.get(c) * P.get(p);
		System.out.println(new DecimalFormat("#.#######").format((ans / ((long) Peter.size() * Colin.size()))));
	}
}