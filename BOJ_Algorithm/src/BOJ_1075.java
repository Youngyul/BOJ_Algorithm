import java.util.*;

public class BOJ_1075 {

	static int result,last;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N,F;
		
		N=sc.nextInt();
		F=sc.nextInt();
		
		//N을 F로 나누어떨어지게하는 숫자.
		int value = N/100;
		
		//최소값. value*100;
		
	
			
			int start = value*100;
			
			result = 0;
			last =0;
			result = start%F;
			
			
			if(result!=0) {
				last =F-result;
			}
			
			if(last<10) {
				System.out.println("0"+last);
			}else {
				System.out.println(last);
			}
	}

}
