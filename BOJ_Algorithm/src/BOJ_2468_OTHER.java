import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2468_OTHER {
	static int[] di = {1, 0, -1 , 0};
	static int[] dj = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		boolean[][] visited =new boolean[N][N];
		int result = 0, height = 0;
		String[] strs;
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(strs[j]);
				height = Math.max(height, map[i][j]);
			}
		}
		
		for(int k = 0; k < height; k++) {
			for(int i = 0; i < N; i++)
				Arrays.fill(visited[i], false);
			
			int temp = 0;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0 ; j < N; j++) {
					if(map[i][j] > k && !visited[i][j]) {
						q.add(i);
						q.add(j);
						temp++;
						visited[i][j] = true;
						
						while(!q.isEmpty()) {
							int ci = q.poll();
							int cj = q.poll();
							
							for(int a = 0; a < 4; a++) {
								int ni = ci + di[a];
								int nj = cj + dj[a];
								
								if(ni >= N || nj >= N || ni < 0 || nj < 0 || visited[ni][nj] || map[ni][nj] <= k)
									continue;
								
								visited[ni][nj] = true;
								q.add(ni);
								q.add(nj);
							}
						}
					}
				}
			}
			
			result = Math.max(result, temp);
		}
		
		System.out.println(result);
	}
}