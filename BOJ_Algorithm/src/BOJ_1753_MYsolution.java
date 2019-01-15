import java.io.*;
import java.util.*;
import java.util.Collections;

public class BOJ_1753_MYsolution {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] str = br.readLine().split(" ");
		int vertex = Integer.parseInt(str[0]);
		int edge = Integer.parseInt(str[1]);
		
		int K = Integer.parseInt(br.readLine());
		
		int [] distance = new int[vertex+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		boolean [] check = new boolean[vertex+1];
		
		ArrayList<Edge>[] list = new ArrayList[vertex+1];
		
		for(int i = 0; i<=vertex;i++) {
			list[i]=new ArrayList<Edge>();
		}
		
		//간선 정보 입력받기
		for(int i = 0 ; i<edge;i++) {
			str = br.readLine().split(" ");
			int start = Integer.parseInt(str[0]);
			int end = Integer.parseInt(str[1]);
			int value = Integer.parseInt(str[2]);
			list[start].add(new Edge(end,value));
		}
		
		
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		q.add(K);
		distance[K]=0;
		while(!q.isEmpty()) {
			int current = q.poll();
			check[current]= true;
			
			for(int i = 0 ; i<list[current].size();i++) {
				int next = list[current].get(i).end;
				int value = list[current].get(i).value;
				
				if(distance[next]>distance[current]+value) {
					distance[next]=value + distance[current];
					q.add(next);
				}
				
			}
			
		}
		for(int i = 1;i<=vertex;i++) {
			if(check[i]) {
				System.out.println(distance[i]);
			}else {
				System.out.println("INF");;
			}
		}
		
	}

	static class Edge{
		int end;
		int value;
		
		Edge(int end,int value) {
			this.end=end;
			this.value=value;
		}
	}
}
