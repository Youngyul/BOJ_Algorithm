import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class BOJ_13460_SAMSUNG_EX_EXAM {

	static int MAX = 10;

	static class Point {
		public int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		Point()
		{
			this.x=0;
			this.y=0;
		}
	}
	
	static class Qdata {
		Point R;
		Point B;
		int cnt;
		
		
		Qdata(Point R, Point B, int cnt)
		{
			this.R = new Point(R.x, R.y);
			this.B = new Point(B.x, B.y);
			this.cnt = cnt;
		}
	}

	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));
		int n, m;
		n=sc.nextInt();
		m=sc.nextInt();
		char arr[][]=new char[n][m];
		Point R =new Point();
		Point B=new Point();
		
		for (int i = 0; i < n; i++)
		{
			String tmp = sc.next();
			for (int j = 0; j < m; j++)
			{
				arr[i][j] = tmp.charAt(j);
				if (arr[i][j] == 'B')
				{
					arr[i][j] = '.';
					B.x = i; B.y = j;
				}
				if (arr[i][j] == 'R')
				{
					arr[i][j] = '.';
					R.x = i; R.y = j;
				}
			}
		}
		
		int ans = -1;
		
		boolean check[][][][] = new boolean[MAX][MAX][MAX][MAX];//(Rx, Ry, Bx, By) 탐색했는지 여부 저장
		for(int i=0;i<MAX;i++)
			for(int j=0;j<MAX;j++)
				for(int k=0;k<MAX;k++)
					Arrays.fill(check[i][j][k], false);
		check[R.x][R.y][B.x][B.y] = true;

		int dx[] = new int[] { -1,1,0,0 };
		int dy[] = new int[] { 0,0,-1,1 };
		
		Queue<Qdata> q = new LinkedList<Qdata>(); //R,B,cnt
		q.add(new Qdata(R,B,0));
		while (!q.isEmpty())
		{
			Qdata now = q.poll();
			R = new Point(now.R.x, now.R.y);
			B = new Point(now.B.x, now.B.y);
			int cnt = now.cnt + 1;
			
			if (cnt > 10) continue;//10번 넘어가면 안됨

			for (int i = 0; i < 4; i++)
			{
				Point nR = new Point(R.x, R.y);
				Point nB = new Point(B.x, B.y);

				while (arr[nR.x + dx[i]][nR.y + dy[i]] != '#')
				{
					nR.x += dx[i];
					nR.y += dy[i];
					if (arr[nR.x][nR.y] == 'O') break;
				}
				while (arr[nB.x + dx[i]][nB.y + dy[i]] != '#') 
				{
					nB.x += dx[i];
					nB.y += dy[i];
					if (arr[nB.x][nB.y] == 'O') break;
				}

				//파란 공 나옴
				if (arr[nB.x][nB.y] == 'O')
					continue;
				//빨간 공만 빠져나옴
				if (arr[nR.x][nR.y] == 'O')
				{
					System.out.println(cnt);
					System.exit(0);//종료
				}
				
				//겹친 경우
				if (nR.x == nB.x && nR.y == nB.y)
				{
					if (dx[i] != 0)
					{
						if (R.x * dx[i] > B.x * dx[i]) nB.x -= dx[i];
						else nR.x -= dx[i];
					}
					else
					{
						if (R.y * dy[i] > B.y * dy[i]) nB.y -= dy[i];
						else nR.y -= dy[i];
					}
				}

				//방문 안한 것만 큐에 push
				if (check[nR.x][nR.y][nB.x][nB.y] == true) continue;
				
				q.add(new Qdata(nR,nB,cnt));
				check[nR.x][nR.y][nB.x][nB.y] = true;
			}
		}
		System.out.println(ans);
		
	}
}
