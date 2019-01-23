import java.io.*;
import java.util.*;

public class BOJ_14503_20190123_fail {

	static int N,M;
	static int r, c, d;
	static int arr [][];
	static boolean check [][];
	static int xx [] = {-1,0,1,0};
	static int yy [] = {0,1,0,-1};
	static int result ; 	//청소하는 칸의 숫자.
	static Queue<Node> q = new LinkedList<>();
	static int nowx,nowy;
	static int nextx,nexty;
	static int nowd;
	
	//북->서->남->동->북
	 
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str [] = br.readLine().split(" ");
		
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		arr = new int[N+1][M+1];
		
		
		String str2 [] = br.readLine().split(" ");
		
		r = Integer.parseInt(str2[0]);
		c = Integer.parseInt(str2[1]);
		d = Integer.parseInt(str2[2]);
		
		
		//로봇 청소기 위치 [r][c] , d방향 바라봄. d==0 북쪽, d==1 동쪽 
		// d==2 남쪽, d==3 서쪽.
		
		for(int i =1;i<=N;i++) {
			String str3 [] = br.readLine().split(" ");
			for(int j =1;j<=M;j++) {
				arr[i][j]=Integer.parseInt(str3[j-1]);
			}
		}
		//입력완료
		
		
		result = 0;
		check = new boolean[N+1][M+1];
		
		
		/*
		for(int i =1;i<=N;i++) {
			for(int j =1;j<=M;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		*/
		
		BFS(r,c,d);
		System.out.println(result);
		
		
	} //main종료
	
	static void BFS(int a, int b,int d) {
		
		q.add(new Node(a,b,d));
		check[a][b]=true;
		nowd =d;
		result+=1;
		//현재위치를 청소한다.
		
		while(!q.isEmpty()) {
			//왼쪽 탐색.
			
			Node nownode = q.poll();
			nowx = nownode.x;
			nowy = nownode.y;
			result ++;
			
			//벽은 1, 빈공간은 0 .외곽은 1.
			//d은 현재의 방향.
			for(int i =0;i<4;i++) {
				nextx = nowx+xx[i];
				nexty = nowy+yy[i];
				
				if(nextx>1&&nextx<M&&nexty>1&&nexty<N) {
					if(check[nextx][nexty]==false&&arr[nextx][nexty]==0) {
						check[nextx][nexty]=true;
						q.add(new Node(nextx,nexty,nowd-1));
					}
				}
				
				if(nextx<=1||nextx>=M||nexty<=1||nexty>=N) {
					if(check[nextx][nexty]==true||arr[nextx][nexty]==1) {
						if(nowd ==0) {
							BFS(nowx,nowy-1,nowd);
						}
						if(nowd ==1) {
							BFS(nowx-1,nowy,nowd);
						}
						if(nowd==2) {
							BFS(nowx,nowy+1,nowd);
						}
						if(nowd==3) {
							BFS(nowx+1,nowy,nowd);
						}
					}
				}
				
			}
			
			
			
		
			
		}
		
		
	}	// BFS 완료.

	static void play1(int a, int b, int d){
		
		//[a][b], 방향은 d d를 기준으로 왼쪽방향부터 차례로 탐색을 진행한다.
		
		if(d%4==0) {
			//북쪽을 바라보고 있음. 따라서 왼쪽은 -1,0
			nextx = a-1;
			nexty = b;
		}
		if(d%4==1) {
			//동쪽을 바라보고있음. 따라서 왼쪽은 0,1
			nextx = a;
			nexty = b+1;
		}
		if(d%4==2) {
			//남쪽을 바라보고있음. 따라서 왼쪽은 1,0
			nextx = a+1;
			nexty = b;
		}
		if(d%4==3) {
			//서쪽을 바라보고있음. 따라서 왼쪽은 0,-1
			nextx = a;
			nexty =b-1;
		}
	
	}
	
	
	
	static class Node{
		int x; 
		int y;
		int d;
		Node(int x, int y,int d){
			this.x=x;
			this.y=y;
			this.d=d;
		}
	}
	
}// 전체종료
