import java.util.*;

public class BOJ_2455 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			Scanner sc = new Scanner(System.in);
			int inpeople [] = new int [4];
			int outpeople [] = new int [4];
			int nowpeople = 0;
			
			for(int i = 0 ; i<4;i++) {
				outpeople[i]= sc.nextInt();
				inpeople[i]=sc.nextInt();
			}
			int max = 0;
			for(int i = 0 ; i<4;i++) {
				nowpeople= nowpeople -outpeople[i]+inpeople[i];
				if(max<nowpeople) {
					max= nowpeople; 
				}
			}
			System.out.println(max);
	}

}
