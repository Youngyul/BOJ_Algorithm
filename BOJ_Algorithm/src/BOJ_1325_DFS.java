import java.util.*;

public class BOJ_1325_DFS {

	static boolean check[]=new boolean[10001];
	static ArrayList<Integer> arr[];
	static int result [] = new int[10001];
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		 arr= (ArrayList<Integer>[])new ArrayList[n+1];
		
		for(int i = 1;i<=n;i++) {
			arr[i]=new ArrayList<>();
		}
		
		for(int i =0;i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			arr[a].add(b);
		}
	
		int max = 0;
		for(int i =1;i<=n;i++) {
			check = new boolean[100001];
			DFS(i);
		}
		for(int i=1;i<=n;i++) {
			if(max<result[i]) {
				max = result[i];
			}
		}
		for(int i = 1;i<=n;i++) {
			if(max==result[i]) {
				sb.append(i+" ");
			}
		}
		
		System.out.println(sb.toString());
		
		
	}
	
	static void DFS(int a) {
		check[a]=true;
		
		for(int y:arr[a]) {
			if(check[y]==false) {
				check[y]=true;
				result[y]++;
				DFS(y);
			}
		}
	}

}
