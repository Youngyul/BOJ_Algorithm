import java.io.*;
import java.util.*;

public class BOJ_1916 {
	static int N,M;
	static int start,end;
	static int result [] ;
	static ArrayList<Edge> [] arr;
	static boolean check [];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine().trim());	//도시의 갯수
		M = Integer.parseInt(br.readLine().trim());	//버스의 갯수
		

		arr = new ArrayList[N+1];
		result = new int[N+1];
		check = new boolean[N+1];
		
		for(int i = 1;i<=N;i++) {
			arr[i]= new ArrayList<Edge>();
		}
		
		
		for(int i = 0; i<M;i++) {
			String str [] = br.readLine().split(" ");
			
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			int c = Integer.parseInt(str[2]);
			
			arr[a].add(new Edge(b,c));
			
		}
		
		String str2 []  = br.readLine().split(" ");
		start = Integer.parseInt(str2[0]);
		end = Integer.parseInt(str2[1]);
		
		Arrays.fill(result, Integer.MAX_VALUE);
		
		
		//배열 버스가 없는 경우 초기화.
	
		
		
		dijkstra(start);
		
		
	}	//Main끝

	static void dijkstra(int start) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(start);
		result[start] = 0;
		
		while(!pq.isEmpty()) {
			int current = pq.poll();
			check[current] = true;
			
			for(int i = 0 ; i<arr[current].size();i++) {
				int next = arr[current].get(i).end;
				int value = arr[current].get(i).value;
				
				if(result[next]>result[current]+value) {
					result[next]= result[current]+value;
					pq.add(next);
				}
			}
			
			
		}
		for(int i = 1; i<=N;i++) {
			if(i==end) {
				System.out.println(result[i]);
			}
		}
		
	}
	
	static class Edge{
		int end;
		int value;
		Edge(int end,int value){
			this.end=end;
			this.value=value;
		}
	}
	
} //전체 끝
