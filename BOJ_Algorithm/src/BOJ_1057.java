import java.util.*;

public class BOJ_1057 {

	static int Kim,Lim,N;
	static int arr [] = new int[100000];
	static int result=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		Kim = sc.nextInt();
		Lim = sc.nextInt();
		
		Kim = Kim-1;
		Lim = Lim-1;
	
		result = 0;
		
		while(true) {
		
			result++;
			int a1 = Kim/2;
			int a2 = Lim/2;
			if(a1==a2) {
				break;
			}
			
			Kim=Kim/2;
			Lim=Lim/2;
			
			
		}
		System.out.println(result);
		
	}

}
