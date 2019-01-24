import java.io.*;
import java.util.*;

public class BOJ_14501_fail {

	static int N;
	static int arr [][];
	static boolean check [];
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str  = br.readLine().trim();
		
		N = Integer.parseInt(str);
		
		arr = new int[N+1][2];
		check = new boolean [N+1];
		
		//체크가 true라면  회사에 없기 때문에 상담을 할수 없는 경우.
		
		
		for(int i =1;i<=N;i++) {
			String str2 []  = br.readLine().split(" ");
			for(int j =0;j<str2.length;j++) {
				arr[i][j]= Integer.parseInt(str2[j]);
			}
		}
		
		//N일째에 퇴사.
		
		//1<=arr[i][0]=<5 , 1<=arr[i][1]<=1000
		
		//k일의 상담을 잡았다고 하자. 그렇다면 . 다음에 상담이 가능한 경우는. k+arr[k][0]일 날 부터 상담가능하다.
		//1일에 상담을 잡는다. 1일의 값 arr[0][1]이 획득된다. 그다음 상담가능날짜는 arr[0][0]+1일부터 가능하다.
		
		int sum = 0;
		int max = 0;
		
		
		for(int i =1;i<=N;i++) {
			if(i+arr[i][0]>N+1) {
				check[i]=true;
				System.out.print("불가능한것들 : "+ i+" ");
				//check가 true라면. 기간안에 상담을 마무리하지 못하는 경우이다.
			}
		}
	
		/*
		for(int i =1;i<=N;i++) {
			for(int j =0;j<2;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		*/
		
		
		int result = 0;
		for(int i=1;i<=N;i++) {
			int sum2 =0;
			if(check[i]==false) {
				sum2 = bruteforce(i);
				if(sum2>result) {
				result = sum2;
				}
			}
		}
		
		//왜 1이 80이 나오는지 알아봐야겠다.
		System.out.print(bruteforce(1));
		
		
		
		
		
		System.out.print(result);

	}
	
	static int bruteforce(int startday) {
		
		Queue<Day> q = new LinkedList<>();
		int nowday = startday;
		int needtime = arr[startday][0];
		int cost = arr[startday][1];
		
		int sum = 0;
		int max = sum;
		
		q.add(new Day(nowday,needtime,cost));
		
		
		while(!q.isEmpty()) {
			
			Day nowd = q.poll();
			
			int nowdate = nowd.nowday;
			int nowneedtime = nowd.needtime;
			int nowcost = nowd.cost;
			
			sum += nowcost;
		

			int nextsmalltime= nowdate +nowneedtime;
			int nexttime;
			int nextcost ;
			int nextneedtime ;
			
			for(int j = nextsmalltime;j<=N;j++) {
				
				if(check[j]==true) {
					continue;
				}
				
				
				nexttime = j;
				nextcost = arr[j][1];
				nextneedtime = arr[j][0];
				
				System.out.println(nexttime+" 추가가능");
				
				q.add(new Day(nexttime,nextneedtime,nextcost));
				break;
				
				
			}
			
		}
		if(max<sum) {
			max=sum;
		}

		return max;
	}
	
	
	
	
	
	static class Day{
		int nowday;
		int needtime;
		int cost;
		
		Day(int nowday,int needtime,int cost){
			this.nowday=nowday;
			this.needtime=needtime;
			this.cost=cost;
		}
	}
}
