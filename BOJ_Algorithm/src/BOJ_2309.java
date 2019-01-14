import java.util.*;

public class BOJ_2309 {

	static int k,n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int arr []  =new int[9];
		
		int sum = 0;
		
		for(int i = 0 ; i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		for(int i = 0; i<arr.length;i++) {
			sum+=arr[i];
		}
		Arrays.sort(arr);
		//sum´Â 9°³ÀÇ ÇÕ.
		
		//0 , 1, 2 , 3 ,4 , 5 ,6 ,7,8
		for(int i = 0 ;i<8;i++) {
			for(int j = i+1;j<9;j++) {
				if(sum-arr[i]-arr[j]==100) {
		//arr[i],arr[j]°¡ Â¦ÅüÀÌ´Ù.
					k = i;
					n = j;
			}
		}
	}
		for(int i = 0 ; i<arr.length;i++) {
			if(i!=k&&i!=n) {
				System.out.println(arr[i]);
			}
		}
	
	}

}
