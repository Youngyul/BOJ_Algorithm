import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



//��ó : ���̱��̴�  https://mygumi.tistory.com/107



public class BOJ_9466 {

	private void solve() {
		int t = sc.nextInt();
		StringBuilder sb = new StringBuilder();

		// a - ����, c - �湮, s - ��������

		while (t-- > 0) {
			int n = sc.nextInt();

			int[] a = new int[n + 1];
			int[] c = new int[n + 1];
			int[] s = new int[n + 1];
			int ans = 0;

			for (int i = 1; i <= n; i++) {
				int v = sc.nextInt();

				a[i] = v;
			}
			
			for(int i=1;i<=n;i++) {
				if (c[i] == 0) {
					ans += dfs(a,c,s,i,i);
				}
			}
			sb.append((n - ans) + "\n");
		}
		System.out.println(sb.toString());
	}

	public static int dfs(int[] a, int[] c, int[] s, int v, int step) {
		int cnt = 1;

		while(true) {
			
			if (c[v] != 0) {
				if (s[v] != step) {
					// �̹� �湮�߰�, ���� �������� �ٸ� ��� ����Ŭ x
					return 0;
				}
				return cnt - c[v];
			}
			
			s[v] = step;
			c[v] = cnt;
			v = a[v];
			
			cnt += 1;
		}
		
	}

	public static void main(String[] args) {
		sc.init();

		new BOJ_9466().solve();
	}

	static class sc {
		private static BufferedReader br;
		private static StringTokenizer st;

		static void init() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}

		static String readLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
			}
			return null;
		}

		static String readLineReplace() {
			try {
				return br.readLine().replaceAll("\\s+", "");
			} catch (IOException e) {
			}
			return null;
		}

		static String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
				}
			}
			return st.nextToken();
		}

		static long nextLong() {
			return Long.parseLong(next());
		}

		static int nextInt() {
			return Integer.parseInt(next());
		}

		static double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}