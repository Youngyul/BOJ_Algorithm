import java.util.*;
import java.io.*;
public class SW_1226 {

	static int Testcase;
	static boolean check [][];
	static int arr [][];
	static int startx,starty;
	static int endx,endy;
	static int result ;
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub


		Scanner sc =new Scanner(System.in);
		

		for(int ww =0;ww<10;ww++) {
			Testcase =sc.nextInt();
			
			check = new boolean[16][16];
			arr = new int[16][16];
			
			for(int i =0;i<16;i++) {
				String str = sc.next();
				for(int j =0;j<16;j++) {
					arr[i][j]=Integer.parseInt(str.substring(j, j+1));
				}
			}
			
			for(int i =0;i<16;i++) {
				for(int j =0;j<16;j++) {
					if(arr[i][j]==2) {
						startx = i;
						starty =j;
					}
					if(arr[i][j]==3) {
						endx = i;
						endy = j;
					}
				}
			}
			
			//입력완료.
		
			BFS(startx,starty,arr,check);
			
		
			if(check[endx][endy]==true) {
				result = 1;
			}else {
				result =0;
			}
			System.out.println("#"+Testcase+" "+result);
		}
	}
	static void BFS(int a,int b,int arr [][], boolean check [][]) {
		
		Queue<Node> q = new LinkedList<>();
		check[a][b]=true;
		q.add(new Node(a,b));
		
		int xx [] = {-1,1,0,0};
		int yy [] = {0,0,1,-1};
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			
			int nowx = now.x;
			int nowy = now.y;
			
			for(int i=0;i<4;i++) {
				int nextx = nowx+xx[i];
				int nexty = nowy+yy[i];
				
				if(nextx<0||nextx>15||nexty<0||nexty>15) {
					continue;
				}
				
				if(arr[nextx][nexty]!=1&&check[nextx][nexty]==false) {
					check[nextx][nexty]=true;
					q.add(new Node(nextx,nexty));
					}
			
			}//nextx,nexty를 위한 for end;
			
		}// while end;
	
	}
	
	static class Node{
		int x;
		int y;
		
		Node(int x, int y){
			this.x=x;
			this.y=y;
		}
	}

}
