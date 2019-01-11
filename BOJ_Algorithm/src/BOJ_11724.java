import java.util.*;

public class BOJ_11724 {

	static int N,M;
	static 	ArrayList<Integer> a[] ;
	static boolean check[];
	static int number;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
	
		a= (ArrayList<Integer>[]) new ArrayList[N+1];
	
		for(int i = 1;i<N+1;i++) {
			a[i]= new ArrayList<Integer>();
		}
		
		for(int i = 0 ;i<M;i++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			
			a[m].add(n);
			a[n].add(m);
		}
		number =0 ;
		check = new boolean[N+1];
		
	
		
		for(int i = 1;i<=N;i++) {
			if(check[i]==false) {
				number++;
				DFS(i);
				
			}
		}
		
		System.out.print(number);
	}
	
	static void DFS(int k) {
		
		if(check[k]==true) {
			return;
		}
		
		check[k]=true;
	
		for(int y:a[k]) {
			if(check[y]==false) {
				//System.out.println(y+" ");
				DFS(y);
			}
		}
		
	}
		
		
	
}
