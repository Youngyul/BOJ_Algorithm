import java.util.*;
import java.io.*;

public class SW_1204 {

	static int arr [] = new int[101];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int testcase = sc.nextInt();
		
		for(int i =1;i<=testcase;i++) {
			int N = sc.nextInt();
			arr = new int[101];
	
			for(int j =0;j<1000;j++) {
				int k = sc.nextInt();
				arr[k]++;
			}
			
			int max = 0;
			
			int result = 0;
			
			for(int j = 0;j<101;j++) {
				if(arr[j]>max) {
					max = arr[j];
					result = j;
				}
			}
			
			System.out.println("#"+N+" "+result);
		}
	
		
	}

}
