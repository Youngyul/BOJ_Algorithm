import java.util.*;


public class BOJ_2292 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		//1 + 6 + 12 + 18 + 
		
		int k = 1;
		int result = 0;
		int i = 1;
		
		if(n==k) {
			result = k;
		}
		
		
		
		while(n>k) {
			k= k+6*i;
			i++;
			
			result = i;
			
		}
		
		System.out.println(result);
		
		
	}

}
