package projecteuler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem349 {

	/**
	 * Calculates the number of squares that are black after 10^18 moves of Langton's Ant
	 */
	static void solution() {
		long ans = 0;
		int n = 9984;
		List<Integer> coordinate = Functions.getTuple(0, 0);
		String direction = "up";
		Map<List<Integer>, Integer> d = new HashMap<List<Integer>, Integer>();
		for (int i = 0; i < n; i++) {
			try {
				if (d.get(coordinate) == 0) {
					d.put(coordinate, 1);
					if (direction == "up") {
						direction = "right";
						coordinate = Functions.getTuple(coordinate.get(0) + 1, coordinate.get(1));
					} else if (direction == "right") {
						direction = "down";
						coordinate = Functions.getTuple(coordinate.get(0), coordinate.get(1) - 1);
					} else if (direction == "down") {
						direction = "left";
						coordinate = Functions.getTuple(coordinate.get(0) - 1, coordinate.get(1));
					} else {
						direction = "up";
						coordinate = Functions.getTuple(coordinate.get(0), coordinate.get(1) + 1);
					}
				} else {
					d.put(coordinate, 0);
					if (direction == "up") {
						direction = "left";
						coordinate = Functions.getTuple(coordinate.get(0) - 1, coordinate.get(1));
					} else if (direction == "right") {
						direction = "up";
						coordinate = Functions.getTuple(coordinate.get(0), coordinate.get(1) + 1);
					} else if (direction == "down") {
						direction = "right";
						coordinate = Functions.getTuple(coordinate.get(0) + 1, coordinate.get(1));
					} else {
						direction = "down";
						coordinate = Functions.getTuple(coordinate.get(0), coordinate.get(1) - 1);
					}
				}
			} catch (Exception e) {
				d.put(coordinate, 1);
				if (direction == "up") {
					direction = "right";
					coordinate = Functions.getTuple(coordinate.get(0) + 1, coordinate.get(1));
				} else if (direction == "right") {
					direction = "down";
					coordinate = Functions.getTuple(coordinate.get(0), coordinate.get(1) - 1);
				} else if (direction == "down") {
					direction = "left";
					coordinate = Functions.getTuple(coordinate.get(0) - 1, coordinate.get(1));
				} else {
					direction = "up";
					coordinate = Functions.getTuple(coordinate.get(0), coordinate.get(1) + 1);
				}
			}
		}
		for (int i : d.values())
			ans += i;
		ans += (Math.pow(10, 18) - n) / 104 * 12;
		ans -= 8;
		System.out.println(ans);
	}
}