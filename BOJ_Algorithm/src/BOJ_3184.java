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
		
		 R  = sc.nextInt();	//���Ǽ���
		 C = sc.nextInt();	//���Ǽ���
		
		arr  = new String[R][C];
		
		check = new boolean[R][C];
		
		//.�� ���ʵ�, #�� ��Ÿ��, o�� ��, v�� �����̴�.
		
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
		//BFS�� �����Ͽ�. ��ħ���� ����ִ� ��� ������ ���� ����Ѵ�.
		int k = 0;
		//�湮���� �ʾҰ�, ��Ÿ���� �ƴ϶�� DFS�� �����Ѵ�.!!!
		for(int i = 0 ;i<R;i++) {
			for(int j = 0 ; j<C;j++) {
				if(check[i][j]==false) {
					k++;
					if(!arr[i][j].equals("#")) {
						
					BFS(i,j);
					
				//DFS�� ��������, ��� ��θ� Ž���ϰ� ���� ���� �������� sheep�� �� �������, ���� ��Ƴ��� ����� �״´�. wolf�� �� ���ų� ���� ���, ���� �װ� ����� ��Ƴ��´�.
					
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
