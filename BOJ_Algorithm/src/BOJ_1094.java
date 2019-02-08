import java.util.*;

public class BOJ_1094 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int x  = sc.nextInt();
		
		int stick [] = new int [7];
		stick[0]=64;
		
		for(int i = 1; i<stick.length;i++) {
			stick[i]= stick[i-1]/2;
		
		}
		
		//64 , 32, 16, 8 , 4 2 1 
		
	}

}
