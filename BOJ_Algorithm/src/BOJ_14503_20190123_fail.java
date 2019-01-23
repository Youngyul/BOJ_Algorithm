import java.io.*;
import java.util.*;

public class BOJ_14503_20190123_fail {

	static int N,M;
	static int r, c, d;
	static int arr [][];
	static boolean check [][];
	static int xx [] = {-1,0,1,0};
	static int yy [] = {0,1,0,-1};
	static int result ; 	//û���ϴ� ĭ�� ����.
	static Queue<Node> q = new LinkedList<>();
	static int nowx,nowy;
	static int nextx,nexty;
	static int nowd;
	
	//��->��->��->��->��
	 
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
		
		
		//�κ� û�ұ� ��ġ [r][c] , d���� �ٶ�. d==0 ����, d==1 ���� 
		// d==2 ����, d==3 ����.
		
		for(int i =1;i<=N;i++) {
			String str3 [] = br.readLine().split(" ");
			for(int j =1;j<=M;j++) {
				arr[i][j]=Integer.parseInt(str3[j-1]);
			}
		}
		//�Է¿Ϸ�
		
		
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
		
		
	} //main����
	
	static void BFS(int a, int b,int d) {
		
		q.add(new Node(a,b,d));
		check[a][b]=true;
		nowd =d;
		result+=1;
		//������ġ�� û���Ѵ�.
		
		while(!q.isEmpty()) {
			//���� Ž��.
			
			Node nownode = q.poll();
			nowx = nownode.x;
			nowy = nownode.y;
			result ++;
			
			//���� 1, ������� 0 .�ܰ��� 1.
			//d�� ������ ����.
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
		
		
	}	// BFS �Ϸ�.

	static void play1(int a, int b, int d){
		
		//[a][b], ������ d d�� �������� ���ʹ������ ���ʷ� Ž���� �����Ѵ�.
		
		if(d%4==0) {
			//������ �ٶ󺸰� ����. ���� ������ -1,0
			nextx = a-1;
			nexty = b;
		}
		if(d%4==1) {
			//������ �ٶ󺸰�����. ���� ������ 0,1
			nextx = a;
			nexty = b+1;
		}
		if(d%4==2) {
			//������ �ٶ󺸰�����. ���� ������ 1,0
			nextx = a+1;
			nexty = b;
		}
		if(d%4==3) {
			//������ �ٶ󺸰�����. ���� ������ 0,-1
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
	
}// ��ü����
