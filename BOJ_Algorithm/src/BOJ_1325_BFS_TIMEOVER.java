import java.util.*;

public class BOJ_1325_BFS_TIMEOVER {

	static ArrayList<Integer> arr[];
	static boolean check[];
	static int depth[];
	static int result[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		arr = (ArrayList<Integer>[])new ArrayList[n+1];
		check = new boolean[n+1];
		depth = new int[n+1];
		
		for(int i = 1;i<=n;i++) {
			arr[i]=new ArrayList<Integer>();
		}
		for(int j=0;j<m;j++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
	
			arr[b].add(a);		//뒤의것을 해킹하면 앞의 것도 알수 있다.
		}
		
		for(int i=1;i<=n;i++) {
			Collections.sort(arr[i]);
			//System.out.println(arr[i]);		//간선의 정보.
		}
		
		//각 정점에서 BFS를 실행하여 DEPTH를 구한다.그 값을 counting sort한다.
		for(int i = 1;i<=n;i++) {
			BFS(i);
			check = new boolean[n+1];
		} 
		
		
		result = new int[n+1];
		for(int i=1;i<=n;i++) {
			result[i]=1;
			for(int j =1;j<n+1;j++) {
				if(depth[i]<depth[j]) {
					result[i]++;
				}
			}
		}
		for(int i = 1;i<=n;i++) {
			if(result[i]==1) {
				System.out.print(i+ " ");
			}
		}
		
	}
	
	static void BFS(int a) {
		Queue q = new LinkedList<>();
		q.add(a);
		check[a]=true;
		while(!q.isEmpty()) {
			int k = (Integer)q.remove();
		
			for(int y : arr[k]) {
				if(check[y]==false) {
					check[y]=true;
					q.add(y);
					depth[a]++;
				}
			}
		}
	}
	

}
