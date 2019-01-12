import java.util.*;

public class BOJ_3184 {

	static int sheep;
	static int wolf;
	static int xx [] = {-1,1,0,0};
	static int yy [] = {0,0,1,-1};
	static int R,C;
	static boolean check [][] ;
	static String arr [][];
	static int resultsheep;
	static int resultwolf;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		 R  = sc.nextInt();	//행의숫자
		 C = sc.nextInt();	//열의숫자
		
		arr  = new String[R][C];
		
		check = new boolean[R][C];
		
		//.은 빈필드, #은 울타리, o는 양, v는 늑대이다.
		
		for(int i = 0 ;i<R;i++) {
			String str = sc.next();
			for(int j = 0 ; j<C;j++) {
				arr[i][j]= str.substring(j, j+1);
			}
		}
		
		wolf = 0;
		sheep = 0;
		resultsheep = 0;
		resultwolf = 0;
		//BFS를 실행하여. 아침까지 살아있는 양과 늑대의 수를 출력한다.
		int k = 0;
		//방문하지 않았고, 울타리가 아니라면 DFS를 실행한다.!!!
		for(int i = 0 ;i<R;i++) {
			for(int j = 0 ; j<C;j++) {
				if(check[i][j]==false) {
					k++;
					if(!arr[i][j].equals("#")) {
						
					BFS(i,j);
					
				//DFS를 실행한후, 모든 경로를 탐색하고 나서 같은 구간내에 sheep이 더 많은경우, 양은 살아남고 늑대는 죽는다. wolf가 더 많거나 같은 경우, 양은 죽고 늑대는 살아남는다.
					
				}
				
			}
		}
	}
		System.out.print(resultsheep + " "+ resultwolf);
	}
	
	static void BFS(int a, int b) {
		Queue<Pair> q = new LinkedList<>();
		
		q.add(new Pair(a,b));
		check[a][b]=true;
		
		
		while(!q.isEmpty()) {
			Pair nowp = q.poll();
			int an  = nowp.x;
			int bn = nowp.y;
			
			if(arr[an][bn].equals("v")) {
				wolf+=1;
			}
			if(arr[an][bn].equals("o")) {
				sheep+=1;
			}
			
			
			
			
			for(int i = 0 ;i<4;i++) {
			int nextx = an+xx[i];
			int nexty = bn+yy[i];
			
			if(nextx>=0&&nextx<R&&nexty>=0&&nexty<C) {
				if(!arr[nextx][nexty].equals("#")&&check[nextx][nexty]==false) {
					check[nextx][nexty]=true;
					q.add(new Pair(nextx,nexty));
				}
			}
		}
	}
		if(sheep>wolf) {
			resultsheep+=sheep;
		}
		else {
			resultwolf+=wolf;
		}
		sheep = 0;
		wolf = 0;
		
		
		
		
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
