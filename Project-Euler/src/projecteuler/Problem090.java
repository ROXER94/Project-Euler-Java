package projecteuler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem090 {

	/**
	 * Calculates the number of distinct arrangements of the two cubes that allow for all of the square numbers to be displayed
	 */
	static void solution() {
		int ans = 0;
		List<String> squares = new ArrayList<String>();
		squares.addAll(Arrays.asList("01", "04", "09", "16", "25", "36", "49", "64", "81"));
		List<int[]> cubeList = new ArrayList<int[]>();
		for (int side1 = 0; side1 < 5; side1++)
			for (int side2 = side1 + 1; side2 < 6; side2++)
				for (int side3 = side2 + 1; side3 < 7; side3++)
					for (int side4 = side3 + 1; side4 < 8; side4++)
						for (int side5 = side4 + 1; side5 < 9; side5++)
							for (int side6 = side5 + 1; side6 < 10; side6++)
								cubeList.add(new int[] { side1, side2, side3, side4, side5, side6 });
		int[][] cubes = cubeList.toArray(new int[][] {});
		for (int i = 0; i < cubes.length - 1; i++)
			for (int j = i + 1; j < cubes.length; j++) {
				List<Integer> die1 = new ArrayList<Integer>();
				for (int k : cubes[i])
					die1.add(k);
				List<Integer> die2 = new ArrayList<Integer>();
				for (int k : cubes[j])
					die2.add(k);
				List<String> currentSquares = new ArrayList<String>(squares);
				if (die1.contains(6) && !die1.contains(9))
					die1.add(9);
				if (die1.contains(9) && !die1.contains(6))
					die1.add(6);
				if (die2.contains(6) && !die2.contains(9))
					die2.add(9);
				if (die2.contains(9) && !die2.contains(6))
					die2.add(6);
				for (int side1 : die1)
					for (int side2 : die2) {
						String pair1 = new Integer(side1).toString() + new Integer(side2).toString();
						String pair2 = new Integer(side2).toString() + new Integer(side1).toString();
						if (currentSquares.contains(pair1))
							currentSquares.remove(pair1);
						if (currentSquares.contains(pair2))
							currentSquares.remove(pair2);
					}
				if (currentSquares.size() == 0)
					ans++;
			}
		System.out.println(ans);
	}
}