import java.util.*;
import java.io.*;

public class BOJ_6118 {

	static int N,M;
	static ArrayList<Integer> [] arr;
	static int result [] ;
	static boolean check [];
	static int max;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str [] = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		arr = new ArrayList[N+1];
		check = new boolean[N+1];
		result = new int [N+1];
		
		for(int i = 1; i<=N;i++) {
			arr[i]= new ArrayList<>();
		}
		
		for(int i =0;i<M;i++) {
			String str2 [] = br.readLine().split(" ");
			int a = Integer.parseInt(str2[0]);
			int b = Integer.parseInt(str2[1]);
			
			arr[a].add(b);
			arr[b].add(a);
		}
	
		Arrays.fill(result,Integer.MAX_VALUE);
		
		dijkstra(1);
		
		max = 0;
		int index = 0;
		int same =0;
		
		for(int i = 1; i<=N;i++) {
		if(result[i]>max) {
			max = result[i];
			index = i;
			same = 0;
		}
		if(result[i]==max) {
			same++;
		}
		
		}
	
		System.out.print(index + " "+ max + " "+ same);
		
		
	}//MainÇÔ¼ö ³¡
	
	
	
	static void dijkstra(int start) {
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		q.add(start);
		check[start]=true;
		result[start]=0;
		
		
		while(!q.isEmpty()) {
			int now = q.poll();
			check[now]=true;
			
			
			for(int y=0;y<arr[now].size();y++) {
				int next = arr[now].get(y);
				
				
				if(result[next]>result[now]+1) {
					result[next]=result[now]+1;
					q.add(next);
				}
				
			}
		}
	}
	
	

}
