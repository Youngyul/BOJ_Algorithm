import java.util.*;

public class BOJ_13458_SAMSUNG_EX_EXAM {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
	
		int maincount=0;
		int subcount = 0;
		int result = 0;
		
		int N = sc.nextInt();
		
		int arr [] =  new int [N];
		
		for(int i =0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		maincount = N;
		for(int i =0;i<N;i++) {
			subcount = 0;
			if(arr[i]>B) {
				arr[i]=arr[i]-B;
				
				int k = arr[i]%C;
				if(k==0) {
					subcount=arr[i]/C;
				}else {
					subcount = arr[i]/C+1;
				}
				
				result+=subcount;
			}else {
				continue;
			}
		}
		
		System.out.println(result+maincount);
	}

}
