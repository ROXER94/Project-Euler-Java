package projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;

public class Problem102 {

	/**
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param x3
	 * @param y3
	 * @return the area of a triangle located at points (x1,y1), (x2,y2), and (x3,y3)
	 */
	static double getTriangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
		return .5 * (-y2 * x3 + y1 * (-x2 + x3) + x1 * (y2 - y3) + x2 * y3);
	}

	/**
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param x3
	 * @param y3
	 * @return the first barycentric coordinate of a triangle located at points (x1,y1), (x2,y2), and (x3,y3)
	 */
	static double getBarycentricCoordinate1(int x1, int y1, int x2, int y2, int x3, int y3) {
		return 1 / (2 * getTriangleArea(x1, y1, x2, y2, x3, y3)) * (y1 * x3 - x1 * y3);
	}

	/**
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param x3
	 * @param y3
	 * @return the second barycentric coordinate of a triangle located at points (x1,y1), (x2,y2), and (x3,y3)
	 */
	static double getBarycentricCoordinate2(int x1, int y1, int x2, int y2, int x3, int y3) {
		return 1 / (2 * getTriangleArea(x1, y1, x2, y2, x3, y3)) * (x1 * y2 - y1 * x2);
	}

	/**
	 * Calculates the number of triangles in the text file for which the interior contains the origin
	 */
	static void solution() {
		int ans = 0;
		try (BufferedReader br = new BufferedReader(new FileReader("src/projecteuler/resources/p102_triangles.txt"))) {
			String line = br.readLine();
			while (line != null) {
				int x1 = Integer.parseInt(line.split(",")[0]);
				int y1 = Integer.parseInt(line.split(",")[1]);
				int x2 = Integer.parseInt(line.split(",")[2]);
				int y2 = Integer.parseInt(line.split(",")[3]);
				int x3 = Integer.parseInt(line.split(",")[4]);
				int y3 = Integer.parseInt(line.split(",")[5]);
				double bCoordinate1 = getBarycentricCoordinate1(x1, y1, x2, y2, x3, y3);
				double bCoordinate2 = getBarycentricCoordinate2(x1, y1, x2, y2, x3, y3);
				if (bCoordinate1 > 0 && bCoordinate2 > 0 && 1 - bCoordinate1 - bCoordinate2 > 0)
					ans++;
				line = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(ans);
	}
}