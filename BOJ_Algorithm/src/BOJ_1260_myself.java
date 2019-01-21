import java.util.*;
import java.io.*;


public class BOJ_1260_myself {

	static int N,M,V;
	static ArrayList<Integer> arr [];
	static boolean check [];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str [] = br.readLine().split(" ");
		
		N=Integer.parseInt(str[0]);
		M=Integer.parseInt(str[1]);
		V=Integer.parseInt(str[2]);
		
		arr = new ArrayList[N+1];
		check = new boolean [N+1];
		
		for(int i = 1;i<=N;i++) {
			arr[i]=new ArrayList<>();
		}

		for(int i =0;i<M;i++) {
			String str2 [] = br.readLine().split(" ");
			int a = Integer.parseInt(str2[0]);
			int b = Integer.parseInt(str2[1]);
			
			arr[a].add(b);
			arr[b].add(a);
			
		}
		
		
		
		
		DFS(V);
		
		System.out.println();
		check = new boolean [N+1];
		
		BFS(V);
		
		
		
	}
	
	
	static void BFS(int abc) {
		Queue<Integer> q = new LinkedList<>();
		q.add(abc);
		check[abc]=true;
		
		while(!q.isEmpty()) {
			int k = q.poll();
			
			System.out.print(k+" ");
			
			for(int j=0;j<arr[k].size();j++) {
				int next = arr[k].get(j);
					if(check[next]==false) {
						q.add(next);
						check[next]=true;
				}
			}		
		}
	}
	
	static void DFS(int abc) {
		if(check[abc]==true) {
			return ;
		}
		
		check[abc]=true;
		System.out.print(abc + " ");
		
		for(int i =0;i<arr[abc].size();i++) {
			int next = arr[abc].get(i);
			if(check[next]==false) {
				DFS(next);
			}
		}
	}

}
