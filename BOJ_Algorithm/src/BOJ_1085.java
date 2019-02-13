import java.util.*;

public class BOJ_1085 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int min = x;
		
		int times [] = new int[4];
		
		times[0]=x;
		times[1]=y;
		times[2]=w-x;
		times[3]=h-y;
		
		//x, y, w-1-x,h-1-y 네개를 비교한다.

		Arrays.sort(times);
		
		System.out.println(times[0]);
	}

}
