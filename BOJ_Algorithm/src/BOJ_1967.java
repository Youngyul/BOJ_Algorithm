import java.util.*;

public class BOJ_1967 {

	static int v, u, r;
	static ArrayList<Node>[] adj;
	static int[] dist;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		 	adj = (ArrayList<Node>[]) new ArrayList[10001];
		    dist = new int[10001];
		 
		    for (int i = 1; i <= 10000; i++) {
		        adj[i] = new ArrayList<>();
		    }
		 
		    int n = sc.nextInt();
		 
		    for (int i = 0; i < n-1 ; i++) {
		        int parent = sc.nextInt();
		        int child = sc.nextInt();
		        int weight = sc.nextInt();
		 
		        adj[parent].add(new Node(child, weight));
		        adj[child].add(new Node(parent, weight));
		    }
		 
		    dfs(1, 0);
		 
		    r = 0;
		    dist = new int[10001];
		 
		    dfs(u, 0);
		    System.out.println(r);



		
	}
	
	static void dfs(int v, int d) {
	    dist[v] = d;
	 
	    if (dist[v] > r) {
	        r = dist[v];
	        u = v;
	    }
	 
	    for (Node node : adj[v]) {
	        int next = node.v;
	        int weight = node.w;
	 
	        if (dist[next] == 0) {
	            dfs(next, d + weight);
	        }
	    }
	 
	}

	

	static public class Node {
	    int v;
	    int w;
	 
	    Node(int v, int w) {
	        this.v = v;
	        this.w = w;
	    }
	}

}

