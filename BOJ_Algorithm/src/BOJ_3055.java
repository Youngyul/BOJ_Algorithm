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
	
	//S���� D�ΰ��� bfs;
	
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
		//����� D,����ġ S, ��X,�� *, ������ 4ĭ�̵�. ���� 4ĭ Ȯ��.
		//����ġ CAN'T GO WATER, WATER CAN'T GO BIBER
		
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
					
					//���� �����ϴ� ���� �α��� �̻��� ���. ������� �ٲ����Ѵ�.
					
					BFS_WATER(k,p);	
				}
			}
		}
	
		
		//WATERCNT�� Ȯ���ϱ� ���� �ڵ�
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
		
		
		//BFSCNT�� Ȯ���ϱ� ���� �ڵ�
		System.out.println();
		
		for(int k = 0  ; k<R;k++) {
			for(int p = 0 ; p<C;p++) {
			System.out.print(bfscnt[k][p]);
			}
			System.out.println();
		}
		
		
		//��� ǥ��.
		for(int i = 0 ; i<R;i++) {
			for(int j = 0 ;j<C;j++) {
				if(arr[i][j].equals("D")) {
				//������ �����¿�.
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
	
	//BFS_WATER �Ϻ�.
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
		
		//(a,b)�� ������ġ D, (c,d)�� ���� ��ġ.
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
						//�湮������ ������, ������ġ�� �����ȿ� �������. ��Ҷ�� q�� �ִ´�. 
						// �̹����� ���, �湮����������, �̵��� ������, .�� s�� ����ΰ�츦 �߰��ؾ��ϰ�.
						if(arr[nextx][nexty].equals(".")||arr[nextx][nexty].equals("D")) {
							//.�� s�ӿ��� �ұ��ϰ�, ���� 
							
								//�̵�����.
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
	
	

