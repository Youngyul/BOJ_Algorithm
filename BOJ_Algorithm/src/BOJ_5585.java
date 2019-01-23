import java.util.*;

public class BOJ_5585 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int m = sc.nextInt();
		//m은 제품의 가격.
		
		int n=1000-m;
		
		//500,100,50,10,5,1
		int result  =0;
		
		while(n>0) {
			if(n>=500) {
				int k = n/500;
				n = n-500*k;
				result+=k;
			}
			else if(n>=100) {
				int k = n/100;
				n=n-100*k;
				result+=k;
			}
			else if(n>=50) {
				int k = n/50;
				n=n-50*k;
				result+=k;
			}
			else if(n>=10) {
				int k = n/10;
				n=n-10*k;
				result+=k;
			}
			else if(n>=5) {
				int k = n/5;
				n = n-5*k;
				result +=k;
			}
			else if(n>=1) {
				int k = n/1;
				n= n-1*k;
				result +=k;
			}
			
		}
		System.out.println(result);
	}

}
