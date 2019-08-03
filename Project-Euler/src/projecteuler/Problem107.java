package projecteuler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem107 {

	/**
	 * @param key
	 * @param mstSet
	 * @return the index of the smallest vertex
	 */
	static int getMinKey(int[] key, boolean[] mstSet) {
		int currentMinimum = Integer.MAX_VALUE;
		int minimumIndex = -1;
		for (int v = 0; v < mstSet.length; v++)
			if (!mstSet[v] && key[v] < currentMinimum) {
				currentMinimum = key[v];
				minimumIndex = v;
			}
		return minimumIndex;
	}

	static int getPrimSize(Integer[][] graph) {
		int V = graph.length;
		int[] parent = new int[V];
		int[] key = new int[V];
		boolean[] mstSet = new boolean[V];
		for (int i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}
		key[0] = 0;
		parent[0] = -1;
		for (int count = 0; count < V - 1; count++) {
			int u = getMinKey(key, mstSet);
			mstSet[u] = true;
			for (int v = 0; v < V; v++)
				if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
		}
		int primSize = 0;
		for (int i = 1; i < graph.length; i++)
			primSize += graph[i][parent[i]];
		return primSize;
	}

	/**
	 * Calculates the maximum saving which can be achieved by removing redundant edges whilst ensuring that the network remains connected
	 */
	static void solution() {
		int ans = 0;
		List<Integer[]> matrix = new ArrayList<Integer[]>();
		try (BufferedReader br = new BufferedReader(new FileReader("src/projecteuler/resources/p107_network.txt"))) {
			String line = br.readLine();
			while (line != null) {
				matrix.add(Arrays.stream(Arrays.stream(line.replace("-", "0").split(",")).mapToInt(Integer::parseInt).toArray()).boxed().toArray(Integer[]::new));
				line = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Integer[][] m = matrix.toArray(new Integer[matrix.size()][]);
		for (int i = 0; i < m.length - 1; i++)
			for (int j = i + 1; j < m.length; j++)
				ans += m[i][j];
		ans -= getPrimSize(m);
		System.out.println(ans);
	}
}