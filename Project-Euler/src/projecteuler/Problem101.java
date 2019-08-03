package projecteuler;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem101 {

	/**
	 * @param n
	 * @return a value of the generating function
	 */
	static BigDecimal getU101(int n) {
		return BigDecimal.ONE.subtract(BigDecimal.valueOf(n)).add(BigDecimal.valueOf(Math.pow(n, 2))).subtract(BigDecimal.valueOf(Math.pow(n, 3)))
				.add(BigDecimal.valueOf(Math.pow(n, 4))).subtract(BigDecimal.valueOf(Math.pow(n, 5))).add(BigDecimal.valueOf(Math.pow(n, 6)))
				.subtract(BigDecimal.valueOf(Math.pow(n, 7))).add(BigDecimal.valueOf(Math.pow(n, 8))).subtract(BigDecimal.valueOf(Math.pow(n, 9)))
				.add(BigDecimal.valueOf(Math.pow(n, 10)));
	}

	/**
	 * @param m
	 * @return the transpose of m
	 */
	static BigDecimal[][] getMatrixTranspose(BigDecimal[][] m) {
		List<List<BigDecimal>> l = new ArrayList<List<BigDecimal>>();
		for (int r = 0; r < m.length; r++) {
			List<BigDecimal> tRow = new ArrayList<BigDecimal>();
			for (int c = 0; c < m[r].length; c++)
				if (c == r)
					tRow.add(m[r][c]);
				else
					tRow.add(m[c][r]);
			l.add(tRow);
		}
		BigDecimal[][] t = new BigDecimal[l.size()][];
		for (int i = 0; i < l.size(); i++)
			t[i] = l.get(i).toArray(new BigDecimal[0]);
		return t;
	}

	/**
	 * @param m
	 * @param rowRemove
	 * @param colRemove
	 * @return the minor of m at location rowRemove,colRemove
	 */
	static BigDecimal[][] getMatrixMinor(BigDecimal[][] m, int rowRemove, int colRemove) {
		int rows = m.length;
		int cols = m[0].length;
		BigDecimal[][] matrixMinor = new BigDecimal[rows][cols - 1];
		for (int i = 0; i < rows; i++)
			for (int j = 0, currentCol = 0; j < cols; j++)
				if (j != colRemove)
					matrixMinor[i][currentCol++] = m[i][j];
		List<BigDecimal[]> matrixMinorList = new ArrayList<BigDecimal[]>();
		for (BigDecimal[] i : matrixMinor)
			matrixMinorList.add(i);
		matrixMinorList.remove(rowRemove);
		matrixMinor = new BigDecimal[rows - 1][cols - 1];
		for (int i = 0; i < rows - 1; i++)
			for (int j = 0; j < cols - 1; j++)
				matrixMinor[i][j] = matrixMinorList.get(i)[j];
		return matrixMinor;
	}

	/**
	 * @param m
	 * @return the determinant of m
	 */
	static BigDecimal getMatrixDeterminant(BigDecimal[][] m) {
		if (m.length == 2)
			return m[0][0].multiply(m[1][1]).subtract(m[0][1].multiply(m[1][0]));
		BigDecimal determinant = BigDecimal.ZERO;
		for (int c = 0; c < m.length; c++)
			determinant = determinant.add(BigDecimal.valueOf(Math.pow(-1, c)).multiply(m[0][c]).multiply(getMatrixDeterminant(getMatrixMinor(m, 0, c))));
		return determinant;
	}

	/**
	 * @param m
	 * @return the matrix inverse of m
	 */
	static BigDecimal[][] getMatrixInverse(BigDecimal[][] m) {
		BigDecimal determinant = getMatrixDeterminant(m);
		if (m.length == 2)
			return new BigDecimal[][] {
					new BigDecimal[] { m[1][1].divide(determinant, MathContext.DECIMAL128),
							BigDecimal.valueOf(-1).multiply(m[0][1].divide(determinant, MathContext.DECIMAL128)) },
					new BigDecimal[] { BigDecimal.valueOf(-1).multiply(m[1][0].divide(determinant, MathContext.DECIMAL128)),
							m[0][0].divide(determinant, MathContext.DECIMAL128) } };
		List<List<BigDecimal>> cofactors = new ArrayList<List<BigDecimal>>();
		for (int r = 0; r < m.length; r++) {
			List<BigDecimal> cofactorRow = new ArrayList<BigDecimal>();
			for (int c = 0; c < m.length; c++) {
				BigDecimal[][] minor = getMatrixMinor(m, r, c);
				cofactorRow.add(BigDecimal.valueOf(Math.pow(-1, r + c)).multiply(getMatrixDeterminant(minor)));
			}
			cofactors.add(cofactorRow);
		}
		BigDecimal[][] t = new BigDecimal[cofactors.size()][];
		for (int i = 0; i < cofactors.size(); i++)
			t[i] = cofactors.get(i).toArray(new BigDecimal[0]);
		BigDecimal[][] C = getMatrixTranspose(t);
		for (int r = 0; r < C.length; r++)
			for (int c = 0; c < C.length; c++)
				C[r][c] = C[r][c].divide(determinant, MathContext.DECIMAL128);
		return C;
	}

	/**
	 * @param a
	 * @param b
	 * @return the matrix product of a and b
	 */
	static BigDecimal[][] getMatrixMultiplication(BigDecimal[][] a, BigDecimal[][] b) {
		BigDecimal[][] c = new BigDecimal[a[0].length][];
		for (int i = 0; i < a[0].length; i++) {
			c[i] = new BigDecimal[b[0].length];
			for (int j = 0; j < b[1].length; j++) {
				c[i][j] = BigDecimal.ZERO;
				for (int k = 0; k < a[1].length; k++)
					c[i][j] = c[i][j].add(a[i][k].multiply(b[k][j]));
			}
		}
		return c;
	}

	/**
	 * Calculates the sum of the FITs for the BOPs
	 */
	static void solution() {
		BigDecimal ans = BigDecimal.ONE;
		BigDecimal[][] BOPS = new BigDecimal[10][];
		for (int i = 0; i < 10; i++)
			BOPS[i] = new BigDecimal[] { (BigDecimal) getU101(i + 1) };
		for (int i = 2; i <= BOPS.length; i++) {
			BigDecimal[][] BOPSsubset = Arrays.copyOfRange(BOPS, 0, i);
			List<List<BigDecimal>> ReversedPowers = new ArrayList<List<BigDecimal>>();
			for (int j = 1; j <= BOPSsubset.length; j++) {
				List<BigDecimal> ReversedPowersElements = new ArrayList<BigDecimal>();
				for (int k = 0; k < BOPSsubset.length; k++)
					ReversedPowersElements.add(BigDecimal.valueOf(Math.pow(j, k)));
				Collections.reverse(ReversedPowersElements);
				ReversedPowers.add(ReversedPowersElements);
			}
			BigDecimal[][] M = new BigDecimal[ReversedPowers.size()][];
			for (int j = 0; j < ReversedPowers.size(); j++)
				M[j] = ReversedPowers.get(j).toArray(new BigDecimal[0]);
			BigDecimal[][] MatrixProduct = getMatrixMultiplication(getMatrixInverse(M), BOPSsubset);
			Collections.reverse(Arrays.asList(MatrixProduct));
			List<BigDecimal> FlattenedMatrixProduct = new ArrayList<BigDecimal>();
			for (BigDecimal[] mp : MatrixProduct)
				for (BigDecimal d : mp)
					FlattenedMatrixProduct.add(d);
			for (int j = 0; j < FlattenedMatrixProduct.size(); j++)
				ans = ans.add(FlattenedMatrixProduct.get(j).multiply(BigDecimal.valueOf(Math.pow((FlattenedMatrixProduct.size() + 1), j))).setScale(0, RoundingMode.HALF_UP));
		}
		System.out.println(ans);
	}
}