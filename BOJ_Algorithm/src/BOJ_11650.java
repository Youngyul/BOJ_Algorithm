import java.util.*;

public class BOJ_11650 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		ArrayList<Pair> arr = new ArrayList<>();
		
		//brr처럼 Integer을 이용하면, Arraylist에는 각각 하나의 인자만을 삽입할 수 있다.
		//ArrayList<Integer> brr = new ArrayList<>();
		for(int i = 0 ;i <N;i++) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		arr.add(new Pair(a,b));
		//brr.add(a);
		//brr.add(b);
		}
		
		/*for(int i = 0 ; i<N;i++) {
			System.out.print(arr.get(i).getX()+" ");
			System.out.println(arr.get(i).getY());
		}
		*/
		
		Collections.sort(arr, new Comparator<Pair>() {
			public int compare(Pair a, Pair b) {
				if(a.getY()<b.getY()) {
					return -1;
				}else if(a.getY()==b.getY()) {
					if(a.getX()<b.getX()) {
						return -1;
					}else {
						return 1;
					}
				}else {
					return 1;
				}
			}
		});
		
		for(Pair p : arr) {
			System.out.println(p.getX()+" "+p.getY());
		}
		
	}
	
	static class Pair{
	
		private int a;
		private int b;
		
		Pair(int a,int b){
			this.a=a;
			this.b=b;
	
		}
		
		int getX() {
			return this.a;
		}
		int getY() {
			return this.b;
			
		}
	}
	
	

}
