import java.util.*;

public class BOJ_2217 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			Scanner sc = new Scanner(System.in);
			
			int N = sc.nextInt();
			
			int arr [] = new int[N];
			int k = 0;
			for(int i = 0;i<N;i++) {
				arr[i]=sc.nextInt();
			}
			Arrays.sort(arr);
			
		for(int i=N-1;i>-1;i--) {
			if(k<arr[i]*(N-i)) {
				k=arr[i]*(N-i);
			}
		}
		System.out.println(k);
		sc.close();
			
	}

}
