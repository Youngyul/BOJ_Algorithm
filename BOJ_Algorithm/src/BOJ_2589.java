import java.util.*;

public class BOJ_2589 {

	static boolean check[][];
	static int time[][];
	static int max=0;
	static int rx[]= {-1,1,0,0};
	static int ry[]= {0,0,-1,1};
	static int A;
	static int B;
	static String map[][];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		A = sc.nextInt();
		B = sc.nextInt();
		
		map = new String[A][B];
		
		time=new int[A][B];
		
		for(int i = 0;i<A;i++) {
			String str = sc.next();
			for(int j = 0;j<B;j++) {
				map[i][j]=str.substring(j,j+1);
			}
		}
		
		/* 제대로 입력받았는지 확인.
		for(int i = 0;i<a;i++) {
			for(int j = 0;j<b;j++) {
				System.out.print(map[i][j]);
			}System.out.println();
		}
		*/
		
		int answer = 0;
		for(int i = 0 ;i<A;i++) {
			for(int j = 0;j<B;j++) {
				int max_map=0;
				if(map[i][j].equals("L")) {
					//System.out.println(i+"행"+j+"열"+" ");
					check= new boolean[A][B];
					max_map=BFS(i,j,map);	
				}
				if(max_map>answer) {
					answer=max_map;
				}
			}
		}
		System.out.println(answer);	
	}
	
	
	static int BFS(int a, int b,String [][]map) {
		Queue<Pair> q= new LinkedList<>();
		if(check[a][b]==false) {
			q.add(new Pair(a,b));
			check[a][b]=true;
			time[a][b]=0;
		}
		while(!q.isEmpty()) {
			Pair p = q.remove();
			int nowx = p.getx();
			int nowy = p.gety();
			
			for(int i = 0;i<4;i++) {
				int nextx = nowx+rx[i];
				int nexty = nowy+ry[i];
			
			if(nextx>=0&&nextx<A&&nexty>=0&&nexty<B) {
				if(map[nextx][nexty].equals("L")&&check[nextx][nexty]==false) {
						q.add(new Pair(nextx,nexty));
						check[nextx][nexty]=true;
						time[nextx][nexty]=time[nowx][nowy]+1;
					}
				}
			}
		}
		
		/*
		for(int i = 0;i<A;i++) {
			for(int j = 0;j<B;j++) {
				System.out.print(check[i][j]+" ");
			}System.out.println();
		}
		System.out.println();
		*/
		
		int max = 0;
		for(int i = 0;i<A;i++) {
			for(int j = 0;j<B;j++) {
				if(time[i][j]>max) {
					max=time[i][j];
				}
			}
		}
		//System.out.println(max);
		return max;
	}
	
	static class Pair{
		private int a;
		private int b;
		
		Pair(int a, int b){
			this.a=a;
			this.b=b;
		}
		int getx() {return this.a;}
		int gety() {return this.b;}
	}

}
