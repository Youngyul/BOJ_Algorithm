import java.util.*;

public class BOJ_1260_SECOND {

	static int N,M,V;
	static ArrayList<Integer> arr  [];
	static boolean check [];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		V=sc.nextInt();
		
		
		arr  = new ArrayList[N+1];
		check = new boolean[N+1];
		
		for(int i = 1;i<=N;i++) {
			arr[i]= new ArrayList<>();
		}
		
		for(int i = 0;i<M;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			arr[a].add(b);
			arr[b].add(a);
		}
		
		for(int i =1;i<=N;i++) {
			Collections.sort(arr[i]);
		}
		
		dfs(V);
		check = new boolean[N+1];
		System.out.println();
		bfs(V);
		
	}
	
	//stack Àç±ÍÀÌ¿ë
	static void dfs(int k) {
		if(check[k]==true) {
			return;
		}
		check[k] = true;
		System.out.print(k+" ");
		
		for(int i =0;i<arr[k].size();i++){
			int n = arr[k].get(i);
			if(check[n]==false) {
				dfs(n);
			}
		}
		
		
	}
	
	static void bfs(int k) {
	
		Queue<Integer> q = new LinkedList<>();
		q.add(k);
		check[k]=true;
		
		while(!q.isEmpty()) {
			int now = q.remove();
			System.out.print(now+" ");
			int next ;
			for(int i :arr[now]) {
				next = i;
				if(check[next]==false) {
					q.add(next);
					check[next]=true;
				}
			}
		}
		
	}
	

}
