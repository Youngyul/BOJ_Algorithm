import java.util.*;

public class BOJ_2845 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int arr [] = new int [5];
		
		for(int i = 0 ; i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		
		int exp = a*b;
		
		for(int i = 0 ;i <arr.length;i++) {
			System.out.print(arr[i]-exp+" ");
		}
		
	}

}
