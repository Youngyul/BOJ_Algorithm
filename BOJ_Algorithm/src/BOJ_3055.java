import java.util.*;

public class BOJ_3055 {

	static int R,C;
	static String arr [][];
	static boolean water [][];
	static boolean check [][];
	static int cnt;
	static int xx [] = {-1,1,0,0};
	static int yy [] = {0,0,-1,1};
	static int watercnt [][];
	static int bfscnt[][];
	static int x,y;
	static int watercount;
	
	//S에서 D로가는 bfs;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		R = sc.nextInt();
		C = sc.nextInt();
		
		arr = new String [R][C];
		
		for(int i = 0 ; i<R;i++) {
			String str = sc.next();
		for(int j  = 0 ;j<C;j++) {
			arr[i][j]= str.substring(j, j+1);
		}
		}
		//비버굴 D,고슴도치 S, 돌X,물 *, 인접한 4칸이동. 물도 4칸 확장.
		//고슴도치 CAN'T GO WATER, WATER CAN'T GO BIBER
		
		water = new boolean[R][C];
		check = new boolean[R][C];
		cnt = 0;
		watercnt = new int[R][C];
		bfscnt = new int[R][C];
		
		for(int k = 0  ; k<R;k++) {
			for(int p = 0 ; p<C;p++) {
				if(arr[k][p].equals("*")) {
				
					watercnt[k][p]=0;
					water = new boolean[R][C];
					
					//물이 시작하는 곳이 두군데 이상인 경우. 결과값이 바뀌어야한다.
					
					BFS_WATER(k,p);	
				}
			}
		}
	
		
		//WATERCNT를 확인하기 위한 코드
		for(int k = 0  ; k<R;k++) {
			for(int p = 0 ; p<C;p++) {
			System.out.print(watercnt[k][p]);
			}
			System.out.println();
		}
		
		
		
		
		
		for(int k = 0  ; k<R;k++) {
			for(int p = 0 ; p<C;p++) {
				if(arr[k][p].equals("S")) {
					BFS(k,p);	
				}
			}
		}
		
		
		//BFSCNT를 확인하기 위한 코드
		System.out.println();
		
		for(int k = 0  ; k<R;k++) {
			for(int p = 0 ; p<C;p++) {
			System.out.print(bfscnt[k][p]);
			}
			System.out.println();
		}
		
		
		//결과 표출.
		for(int i = 0 ; i<R;i++) {
			for(int j = 0 ;j<C;j++) {
				if(arr[i][j].equals("D")) {
				//목적지 상하좌우.
					if(bfscnt[i][j]!=0) {
						System.out.println(bfscnt[i][j]);
					}
					else {
						System.out.println("KAKTUS");
					}
				}
			}
		}
		
	
		
	}
	
	//BFS_WATER 완벽.
	static void BFS_WATER(int a,int b) {
		
		watercnt[a][b]=0;

		
		Queue<Pair> qwater = new LinkedList<>();
		qwater.add(new Pair(a,b));
		water[a][b]=true;
		while(!qwater.isEmpty()) {
			Pair nowwater = qwater.remove();
			int nowwaterx = nowwater.x;
			int nowwatery = nowwater.y;
			for(int i = 0 ; i<4;i++) {
				int nextwaterx = nowwaterx+xx[i];
				int nextwatery = nowwatery+yy[i];
				if(nextwaterx>=0&&nextwaterx<R&&nextwatery>=0&&nextwatery<C) {
					if(water[nextwaterx][nextwatery]==false&&arr[nextwaterx][nextwatery].equals(".")) {
						if(watercnt[nextwaterx][nextwatery]==0) {
						watercnt[nextwaterx][nextwatery]=watercnt[nowwaterx][nowwatery]+1;
						water[nextwaterx][nextwatery]=true;
						qwater.add(new Pair(nextwaterx,nextwatery));
						}
						else {
							int watercount = watercnt[nextwaterx][nextwatery];
							if(watercount>watercnt[nowwaterx][nowwatery]+1) {
								watercnt[nextwaterx][nextwatery]=watercnt[nowwaterx][nowwatery]+1;
								water[nextwaterx][nextwatery]=true;
								qwater.add(new Pair(nextwaterx,nextwatery));
							}
							else {
								watercnt[nextwaterx][nextwatery]=watercount;
								water[nextwaterx][nextwatery]=true;
								qwater.add(new Pair(nextwaterx,nextwatery));
							}
						}
					}
					if(water[nextwaterx][nextwatery]==false&&arr[nextwaterx][nextwatery].equals("D")) {
						if(watercnt[nextwaterx][nextwatery]==0) {
							watercnt[nextwaterx][nextwatery]=watercnt[nowwaterx][nowwatery]+1;
						}
						else {
							int nowwatercnt = watercnt[nextwaterx][nextwatery];
							if(nowwatercnt<watercnt[nowwaterx][nowwatery]+1) {
								watercnt[nextwaterx][nextwatery]=watercnt[nowwaterx][nowwatery]+1;
							}
						}
					}
				}
			}
		}
		
		
	}
	
	
	
	static void BFS(int a, int b) {
		
		//(a,b)는 시작위치 D, (c,d)는 물의 위치.
		Queue<Pair> q = new LinkedList<>();
	
		
		q.add(new Pair(a,b));
		check[a][b]=true;
		bfscnt[a][b]=0;
		
		
		while(!q.isEmpty()) {
			Pair nowp = q.remove();
			int nowx = nowp.x;
			int nowy = nowp.y;
			
		
		
			for(int i = 0 ;i<4;i++) {
				int nextx = nowx+xx[i];
				int nexty = nowy+yy[i];
				
				if(nextx>=0&&nextx<R&&nexty>=0&&nexty<C) {
					if(check[nextx][nexty]==false) {
						//방문한적이 없으며, 다음위치가 구간안에 있을경우. 평소라면 q에 넣는다. 
						// 이문제의 경우, 방문한적없으며, 이동이 가능한, .과 s인 경우인경우를 추가해야하고.
						if(arr[nextx][nexty].equals(".")||arr[nextx][nexty].equals("D")) {
							//.과 s임에도 불구하고, 만약 
							
								//이동가능.
							    if(bfscnt[nowx][nowy]<watercnt[nextx][nexty]-1) {
								check[nextx][nexty]=true;
								bfscnt[nextx][nexty]=bfscnt[nowx][nowy]+1;
								q.add(new Pair(nextx,nexty));
								}
							   
						}
				
					}
				}
				
				
			}
		}
		
	
		}
		
	
	
	static class Pair{
		int x;
		int y;
	
		Pair(int x, int y) {
			this.x=x;
			this.y=y;
			
		}
	}
	
	
	}
	
	

