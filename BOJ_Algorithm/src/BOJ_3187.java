import java.util.*;
import java.io.*;
public class BOJ_3187 {

	static int R,C;
	static String arr [][];
	static boolean check [][];
	static int xx [] = {-1,1,0,0};
	static int yy [] = {0,0,-1,1};
	static int wolf=0;
	static int sheep=0;
	static int insheep,inwolf;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String [] str = br.readLine().split(" ");
		R=Integer.parseInt(str[0]);
		C=Integer.parseInt(str[1]);
		
		arr = new String[R][C];
		check = new boolean[R][C];
		
		//입력완료
		for(int i = 0; i<R;i++) {
			String st = br.readLine();
			for(int j = 0; j<C;j++) {
				arr[i][j]= st.substring(j, j+1);
			}
		}
		
		for(int i = 0; i<R;i++) {
			for(int j = 0; j<C;j++) {
				if(!arr[i][j].equals("#")&&check[i][j]==false) {
					BFS(i,j);
					
					
					if(insheep >inwolf) {
						inwolf = 0;
						sheep +=insheep;
						insheep = 0;
					}
					if(insheep<=inwolf){
						insheep = 0;
						wolf+=inwolf;
						inwolf = 0;
					}
					
					
				}
			}
		}

		System.out.print(sheep +" "+wolf);
		
	}
	
	static void BFS(int i, int j) {
		
		Queue<Pair> q =new LinkedList<>();
		q.add(new Pair(i,j));
		
		check[i][j]=true;
		
		
		
		while(!q.isEmpty()) {
			Pair now = q.remove();
			int nowx = now.x;
			int nowy = now.y;
			
			
			if(arr[nowx][nowy].equals("k")) {
				insheep+=1;
			}
			if(arr[nowx][nowy].equals("v")) {
				inwolf+=1;
			}
			
			
			for(int m = 0 ; m<4;m++) {
				int nextx = nowx+xx[m];
				int nexty = nowy+yy[m];
				
				if(nextx>=0&&nextx<R&&nexty>=0&&nexty<C) {
					if(check[nextx][nexty]==false&&!arr[nextx][nexty].equals("#")) {
						check[nextx][nexty]=true;
						q.add(new Pair(nextx,nexty));
					}
				}
			}
		}
		
	}

	static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
}
