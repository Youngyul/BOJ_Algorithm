import java.util.*;

public class BOJ_2231 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		
		// k+k/100+(k%100)/10+k%10 = n;
		
		int result = 0;
		
		
		//1,000,000
		
		for(int i =1;i<=n;i++) {
			result = i + (i/1000000)+ (i%1000000)/100000+ (i%100000)/10000+ (i%10000)/1000+ (i%1000)/100 + (i%100)/10+(i%10);
			if(result==n) {
				System.out.print(i);
				break;
			}
			if(i==n) {
				System.out.println(0);
			}
		}
		
		
	}

}
