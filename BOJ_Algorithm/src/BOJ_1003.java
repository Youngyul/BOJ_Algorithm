import java.util.Scanner; 
public class BOJ_1003 
{ 
	static int[][] resultArray = null;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int count = Integer.parseInt(scan.nextLine().trim());
		for(int i=0; i < count; i++) {
			int data = Integer.parseInt(scan.nextLine().trim());
			resultArray = new int[data+1][2]; 
			fiboCnt(data);
		}
		scan.close(); 
		}
		static void fiboCnt(int value) {
			resultArray[0][0] = 1;
			resultArray[0][1] = 0;
			if(value == 0) {
				System.out.println(resultArray[0][0] + " " + resultArray[0][1]);
				return; 
			} 
			for(int i=1; i <= value; i++) {
				resultArray[i][0] = resultArray[i-1][1];
				resultArray[i][1] = resultArray[i-1][0] + resultArray[i-1][1];
			}
			System.out.println(resultArray[value][0] + " " + resultArray[value][1]);
		} 
}