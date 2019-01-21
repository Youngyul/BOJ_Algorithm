import java.util.*;
import java.io.*;

public class BOJ_1038 {

	static boolean check [] = new boolean [1000001];
	static int n;
	static int arr [] = new int[6];
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//n번째 감소하는 숫자를 구하기.
		n = Integer.parseInt(br.readLine().trim());
		
		//범위안에서 가장 큰 감소하는 숫자.
		
		for(int i =0; i<10;i++) {
			check[i]=true;
		}
		
		if(n<10) {
			System.out.print(n);
		}
		else {
			n= n-9;

		for(int i = 0;i<=1000000;i++) {
		arr[0]= i/100000;
		arr[1]= (i%100000)/10000;
		arr[2]= (i%10000)/1000;
		arr[3]= (i%1000)/100;
		arr[4]= (i%100)/10;
		arr[5]= i%10;
		
		for(int j = 0;j<5;j++) {
			if(arr[j]>arr[j+1]) {
				check[i]=true;
				//System.out.print(i+" ");
				n--;
			}
		}
		if(n==0) {
			System.out.println(i);
			break;
		}
		
	}
		
		}//else문
	
	
	

	}

}
