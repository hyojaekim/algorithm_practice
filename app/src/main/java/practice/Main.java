package practice;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] firstLine = sc.nextLine().split(" ");
		int n = Integer.parseInt(firstLine[0]);
		int m = Integer.parseInt(firstLine[1]);

		int[][] board = new int[m][2];
		for (int i = 0; i < m; i++) {
			String[] line = sc.nextLine().split(" ");
			board[i][0] = Integer.parseInt(line[0]);
			board[i][1] = Integer.parseInt(line[1]);
		}

		Main main = new Main();
		System.out.println(main.solution(n, m, board));
	}

	public int solution(int N, int M, int[][] reqInfo) {
		int result = 0;
		Map<Integer, List<Integer>> graph = init(N, M, reqInfo); //그래프 초기화
		boolean[] visited = new boolean[N + 1];
		visited[0] = true;

		for (int vertex = 1; vertex <= N; vertex++) { //방문하지 않은 정점에 dfs 수행
			if (visited[vertex]) continue;
			dfs(graph, visited, vertex);
			result++;
		}
		return result;
	}

	private void dfs(Map<Integer, List<Integer>> graph, boolean[] visited, int curNode) {
		visited[curNode] = true;

		for (Integer node : graph.get(curNode)) {
			if (visited[node]) continue;
			dfs(graph, visited, node);
		}
	}

	private Map<Integer, List<Integer>> init(int n, int m, int[][] reqInfo) {
		HashMap<Integer, List<Integer>> result = new HashMap<>();
		for (int i = 0; i < n; i++) {
			result.put(i + 1, new LinkedList<>());
		}

		for (int i = 0; i < m; i++) {
			result.get(reqInfo[i][0]).add(reqInfo[i][1]);
			result.get(reqInfo[i][1]).add(reqInfo[i][0]);
		}
		return result;
	}
}