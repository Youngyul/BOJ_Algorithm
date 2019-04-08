import java.util.LinkedList;
import java.util.Scanner;

public class BOJ_15683_SAMSUNG_EX_EXAM {

	static LinkedList<Node> cctv = new LinkedList<>();
	static int min;
	static int col;
	static int row;
	static int[][] map;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		col = scan.nextInt();
		row = scan.nextInt();
		min = col * row;
		map = new int[col][row];
		boolean[][] chk_map = new boolean[col][row];

		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				map[i][j] = scan.nextInt();
				if (map[i][j] > 0 && map[i][j] < 6) {
					cctv.add(new Node(map[i][j], i, j));
				}
				if (map[i][j] == 6) {
					chk_map[i][j] = true;
				}
			}
		}
		search(0, chk_map);
		System.out.println(min);

		scan.close();
	}

	public static void search(int start, boolean[][] arr) {

		boolean[][] resArr = new boolean[col][row];
		if (start >= cctv.size()) {
			int count = count(arr);
			if (min > count) {
				min = count;
			}
			return;
		}

		Node n = cctv.get(start);

		switch (n.value) {
		case 1:
			for (int i = 0; i < 4; i++) {
				for (int z = 0; z < col; z++) {
					for (int j = 0; j < row; j++) {
						resArr[z][j] = arr[z][j];
					}
				}

				detect(n, i, resArr);
				search(start + 1, resArr);
			}

			break;
		case 2:

			for (int i = 0; i < 2; i++) {
				for (int z = 0; z < col; z++) {
					for (int j = 0; j < row; j++) {
						resArr[z][j] = arr[z][j];
					}
				}

				i = i * 2;
				detect(n, i, resArr);
				detect(n, i + 1, resArr);
				search(start + 1, resArr);
			}

			break;
		case 3:
			for (int i = 0; i < 4; i++) {
				for (int z = 0; z < col; z++) {
					for (int j = 0; j < row; j++) {
						resArr[z][j] = arr[z][j];
					}
				}

				detect(n, (i) % 2, resArr);
				if (i < 2) {
					detect(n, 2, resArr);
				} else {
					detect(n, 3, resArr);
				}
				search(start + 1, resArr);
			}

			break;
		case 4:
			for (int i = 0; i < 4; i++) {
				for (int z = 0; z < col; z++) {
					for (int j = 0; j < row; j++) {
						resArr[z][j] = arr[z][j];
					}
				}

				for (int j = 0; j < 4; j++) {
					if (j != i) {
						detect(n, j, resArr);
					}
				}
				search(start + 1, resArr);
			}

			break;
		case 5:
			for (int z = 0; z < col; z++) {
				for (int j = 0; j < row; j++) {
					resArr[z][j] = arr[z][j];
				}
			}
			for (int i = 0; i < 4; i++) {

				detect(n, i, resArr);

			}
			search(start + 1, resArr);
			resArr = arr.clone();
			break;
		}
		return;
	}

	public static int count(boolean[][] arr) {
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == false) {
					res++;
				}
			}
		}
		return res;
	}

	static boolean[][] detect(Node node, int dir, boolean[][] arr) {

		switch (dir) {
		case 0:
			for (int i = node.col; i >= 0; i--) {
				if (map[i][node.row] == 6) {
					break;
				}
				arr[i][node.row] = true;
			}

			break;
		case 1:
			for (int i = node.col; i < col; i++) {
				if (map[i][node.row] == 6) {
					break;
				}
				arr[i][node.row] = true;
			}

			break;
		case 2:
			for (int i = node.row; i >= 0; i--) {
				if (map[node.col][i] == 6) {
					break;
				}
				arr[node.col][i] = true;
			}
			break;

		case 3:
			for (int i = node.row; i < row; i++) {
				if (map[node.col][i] == 6) {
					break;
				}
				arr[node.col][i] = true;
			}

			break;
		}
		return arr;
	}

	static class Node {
		int value;
		int col;
		int row;

		public Node(int v, int c, int r) {
			value = v;
			col = c;
			row = r;
		}
	}
}