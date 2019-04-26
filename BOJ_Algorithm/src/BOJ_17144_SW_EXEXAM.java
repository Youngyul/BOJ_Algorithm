import java.util.*;


public class BOJ_17144_SW_EXEXAM {

	static int R,C,T;
	static int arr [][][];
	static Queue<Node> q ;
	static ArrayList<Integer> airx;
	static int xx [] = {-1,0,0,1};
	static int yy [] = {0,1,-1,0};
	static int result [][][];
	static int sum = 0;
	static int brr [][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();
		int time = 0;
		
		arr = new int [R+1][C+1][1001];
		airx = new ArrayList<>();
		
		q = new LinkedList<Node>();
		result = new int[R+1][C+1][1001];
		
		for(int i =0;i<R;i++) {
			for(int j =0;j<C;j++) {
				arr[i][j][0] = sc.nextInt();
				result[i][j][0] = arr[i][j][0];
			}
		}
		
	
	
		
		while(time!=T) {
			time=time+1;
			
		
			for(int i =0;i<R;i++) {
				for(int j =0;j<C;j++) {
					if(result[i][j][time-1]>4) {
						q.add(new Node(i,j));
					}
					if(result[i][j][time-1]<=4) {
						arr[i][j][time]=result[i][j][time-1];
					}
			
				}
			}
			
			
		
		while(!q.isEmpty()) {
			Node now = q.remove();
			int nowx = now.x;
			int nowy = now.y;
			
			int splitvalue = result[nowx][nowy][time-1]/5;
			
			int splitway = 4;
			
			for(int i =0;i<4;i++) {
				int nextx = nowx+xx[i];
				int nexty = nowy+yy[i];
			
				if(nextx<0||nextx>=R||nexty<0||nexty>=C) {
					splitway--;
					continue;
				}
				
				if(result[nextx][nexty][time-1]==-1) {
					splitway--;
					continue;
				}
				
				arr[nextx][nexty][time] +=splitvalue;
				
			}
			
			arr[nowx][nowy][time]+=result[nowx][nowy][time-1]-splitvalue*splitway;
		}
		
		/*
		System.out.println(time+"번째 미세먼지 확산");
		//확산 완료
		for(int i =0;i<R;i++) {
			for(int j =0;j<C;j++) {
				System.out.print(arr[i][j][time]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		*/
		
		
		for(int i =0;i<R;i++) {
			for(int j =0;j<C;j++) {
				result[i][j][time]=arr[i][j][time];
			}
		}
	
		
		//확산 성공. -> 이제 공기청정기를 이용하여 순환을 해야됨.
		for(int i =0;i<R;i++) {
			if(result[i][0][time]==-1) {
				airx.add(i);
			}
		}
		
		int x1 = airx.get(0);
		int x2 = airx.get(1);
		
		result[x1][1][time]=0;
		result[x2][1][time]=0;
		
		for(int i=x1;i<=x2;i++) {
			for(int j =2;j<C;j++) {
				result[i][j][time]= arr[i][j-1][time];
			}
		}
		
		for(int i=0;i<R;i++) {
			if(i==x1||i==x2) {
				continue;
			}
			if(i<x1) {
				result[i][C-1][time] = arr[i+1][C-1][time];
			}
			if(i>x2) {
				result[i][C-1][time] = arr[i-1][C-1][time];
			}
		}
		
		for(int j = C-2;j>=0;j--) {
			result[0][j][time]=arr[0][j+1][time];
			result[R-1][j][time] = arr[R-1][j+1][time];
		}
		
		for(int i = 0;i<R-1;i++) {
			if(i==x1||i==x2||i==0||i==R-1) {continue;}
			
			if(i<x1) {
				result[i][0][time] = arr[i-1][0][time];
			}
			if(i>x2) {
				result[i][0][time] = arr[i+1][0][time];
			}
			
		}
		
		/*
		//공기청정기 결과 확인
		
		System.out.println(time+"번째 공기청정기 후 ");
		// 미세먼지 총합 결과 도출
		for(int i =0;i<R;i++) {
			for(int j =0;j<C;j++) {
				System.out.print(result[i][j][time]+" ");
			}
			System.out.println();
		}
		System.out.println();
		
		*/
		
		}
		
		
		
		for(int i =0;i<R;i++) {
			for(int j =0;j<C;j++) {
				if(result[i][j][time]>0) {
				sum+=result[i][j][time];
				}
			}
		}
		
		// 결과 확인System.out.println("정답은 : "+sum);
		System.out.println(sum);
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
