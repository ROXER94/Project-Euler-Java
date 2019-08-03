package projecteuler;

import java.util.ArrayList;
import java.util.List;

public class Problem265 {

	/**
	 * Calculates the sum of all unique De Bruijn sequences of length 32
	 */
	static void solution() {
		long ans = 0;
		List<String> binary = new ArrayList<String>();
		for (int i = 0; i < 32; i++)
			binary.add(String.format("%05d", Integer.parseInt(Functions.getConvertBase(new Integer(i).toString(), 10, 2))));
		for (int a = 0; a < 2; a++)
			for (int b = 0; b < 2; b++)
				for (int c = 0; c < 2; c++)
					for (int d = 0; d < 2; d++)
						for (int e = 0; e < 2; e++)
							for (int f = 0; f < 2; f++)
								for (int g = 0; g < 2; g++)
									for (int h = 0; h < 2; h++)
										for (int i = 0; i < 2; i++)
											for (int j = 0; j < 2; j++)
												for (int k = 0; k < 2; k++)
													for (int l = 0; l < 2; l++)
														for (int m = 0; m < 2; m++)
															for (int n = 0; n < 2; n++)
																for (int o = 0; o < 2; o++)
																	for (int p = 0; p < 2; p++)
																		for (int q = 0; q < 2; q++)
																			for (int r = 0; r < 2; r++)
																				for (int s = 0; s < 2; s++)
																					for (int t = 0; t < 2; t++)
																						for (int u = 0; u < 2; u++)
																							for (int v = 0; v < 2; v++)
																								for (int w = 0; w < 2; w++)
																									for (int x = 0; x < 2; x++)
																										for (int y = 0; y < 2; y++) {
																											String S = "000001" + new Integer(a).toString()
																													+ new Integer(b).toString()
																													+ new Integer(c).toString()
																													+ new Integer(d).toString()
																													+ new Integer(e).toString()
																													+ new Integer(f).toString()
																													+ new Integer(g).toString()
																													+ new Integer(h).toString()
																													+ new Integer(i).toString()
																													+ new Integer(j).toString()
																													+ new Integer(k).toString()
																													+ new Integer(l).toString()
																													+ new Integer(m).toString()
																													+ new Integer(n).toString()
																													+ new Integer(o).toString()
																													+ new Integer(p).toString()
																													+ new Integer(q).toString()
																													+ new Integer(r).toString()
																													+ new Integer(s).toString()
																													+ new Integer(t).toString()
																													+ new Integer(u).toString()
																													+ new Integer(v).toString()
																													+ new Integer(w).toString()
																													+ new Integer(x).toString()
																													+ new Integer(y).toString() + "1";
																											if (S.length() - S.replace("0", "").length() == 16) {
																												boolean valid = true;
																												for (String B : binary) {
																													if (S.contains(B))
																														continue;
																													else if ((S.substring(S.length() - 4)
																															+ S.substring(0, 4) + S.substring(5)).contains(B))
																														continue;
																													else {
																														valid = false;
																														break;
																													}
																												}
																												if (valid)
																													ans += Integer.parseInt(Functions.getConvertBase(S, 2, 10));
																											}
																										}
		System.out.println(ans);
	}
}