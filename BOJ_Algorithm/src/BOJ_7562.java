import java.util.*;

public class BOJ_7562 {

	static int arr[][];
	static boolean check[][];
	static int xx [] = {2,1,-1,-2,-2,-1,1,2};
	static int yy [] = {1,2,2,1,-1,-2,-2,-1};
	static int a,b,c,d,N;
	static int count[][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc  = new Scanner(System.in);
		int T = sc.nextInt();	//TestCase;
		
	
		for(int i = 0;i<T;i++) {
			arr= new int[301][301];
			check = new boolean[301][301];
			
			N = sc.nextInt(); 	//체스판의 크기.
			
			 a = sc.nextInt();
			 b = sc.nextInt();
			 c = sc.nextInt();
			 d = sc.nextInt();
			 
			BFS(a,b,c,d);
		
		}
	}
	
	static void BFS(int a, int b, int c, int d) {
		
		Queue<Pair> q = new LinkedList<>();
		
		
		
		
		q.add(new Pair(a,b)); //처음 나이트의 위치.
		check[a][b]=true;
		
		while(!q.isEmpty()) {
			Pair nowp = q.remove();
			int nowx = nowp.x;
			int nowy = nowp.y;
			
			if(nowx==c&&nowy==d) {
				System.out.println(arr[nowx][nowy]);
				return;
			}
			
			for(int j = 0;j<8;j++) {
				int nextx = nowx+xx[j];
				int nexty = nowy+yy[j];
				
				if((nextx>=N||nextx<0||nexty>=N||nexty<0)||(arr[nextx][nexty]!=0)) {
				continue;
				}
				else {
					arr[nextx][nexty]=arr[nowx][nowy]+1;
					q.add(new Pair(nextx,nexty));
					check[nextx][nexty]=true;
				}
			}
		}
		
		
	}
	
	static class Pair{
		int x;
		int y;
		Pair(int x,int y){
			this.x=x;
			this.y=y;
		}
	}

}
