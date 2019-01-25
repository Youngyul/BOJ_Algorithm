import java.util.*;
import java.io.*;

public class SW_1204 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str [] = br.readLine().split(" ");
		
		int Testcase = Integer.parseInt(str[0]);
		
		
		for(int i =0;i<Testcase;i++) {
			str = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			
			int arr [] = new int [1000];
			int count[] = new int [101];
			
			str = br.readLine().split(" ");
			
			for(int j =0;j<1000;j++) {
				arr[j]=Integer.parseInt(str[j]);
			}
		
			for(int j =0; j<1000;j++) {
				int k = arr[j];
				count[k]++;
			}
			
			
			
			
			int result = 0;
			int max = 0;
			
			for(int k = 0; k<=100;k++) {
				
				if(count[k]>=max) {
					result = k;
					max = count[k];
				}				
			}
			
			
			
			
			System.out.println("#"+ n + " "+result);
			
			
		}// testcase end;
		
	}

}
