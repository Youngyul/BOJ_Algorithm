import java.util.*;

public class BOJ_1012 {

	
	static int arr[][];
	static boolean check [][];
	static int result;
	static int xn[] = {-1,1,0,0};
	static int yn[] = {0,0,-1,1};
	static Queue<Pair> q;
	static int N,M;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		//TestCASE
		for(int k =0;k<T;k++) {
			M = sc.nextInt();		//가로	
			N = sc.nextInt();		//세로	
			result = 0;					//result 초기화.
			arr = new int[M][N];		// M행 N열 
			check = new boolean[M][N];
			
			int K = sc.nextInt();
			
			
			for(int i = 0;i<K;i++) {
				
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				arr[a][b]=1;
			}
			
		
			
			for(int i = 0;i<M;i++) {
				for(int j = 0;j<N;j++) {
					if(arr[i][j]!=0&&check[i][j]==false) {
		
						BFS(new Pair(i,j));
						result++;
						
					}
				}
			}
			System.out.println(result);
		}
		
	}
	
	static void BFS(Pair p) {

		 q = new LinkedList<>();
		 q.add(p);
		while(!q.isEmpty()) {
			
			Pair nowp = q.remove();
			
			int nowx = nowp.getx();
			int nowy = nowp.gety();
			
			for(int i = 0;i<4;i++) {
				int nextx = nowx+xn[i];
				int nexty = nowy+yn[i];
				
				if(nextx>=0&&nextx<M&&nexty>=0&&nexty<N) {
					if(arr[nextx][nexty]!=0&&check[nextx][nexty]==false) {
						q.add(new Pair(nextx,nexty));
						check[nextx][nexty]=true;	
					}
				}
			}
		
		}
	
	}
	
	static class Pair{
		private int a;
		private int b;
		Pair(int a,int b){
			this.a=a;
			this.b=b;
			
		}
		int getx() {return this.a;}
		int gety() {return this.b;}
	}

}
