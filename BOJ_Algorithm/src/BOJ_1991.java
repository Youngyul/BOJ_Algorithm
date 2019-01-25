import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ���� �¶��� ����
 * 1991
 * Ʈ����ȸ
 * https://118k.tistory.com/490
 * @author whitebeard-k
 *
 */
public class BOJ_1991 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int i, n = Integer.parseInt(in.readLine());
		char[] data = in.readLine().replaceAll(" ", "").toCharArray();

		Tree t = new Tree(data[0], data[1], data[2]);

		for (i = 1; i < n; i++) {
			data = in.readLine().replaceAll(" ", "").toCharArray();
			t.add(data[0], data[1], data[2]);
		}

		t.preOrder(t.root);
		System.out.println();
		t.inOrder(t.root);
		System.out.println();
		t.postOrder(t.root);
	}
}

class TreeNode {
	char data;
	TreeNode left;
	TreeNode right;

	public TreeNode(char data) {
		this.data = data;
	}
}

class Tree {

	TreeNode root;

	public Tree(char data, char left, char right) {
		root = new TreeNode(data);

		if (data != '.')
			root = new TreeNode(data);
		if (left != '.')
			root.left = new TreeNode(left);
		if (right != '.')
			root.right = new TreeNode(right);
	}

	public void add(char data, char left, char right) {
		next(root.left, data, left, right);
		next(root.right, data, left, right);
	}

	public void next(TreeNode node, char data, char left, char right) {
		if (node == null)
			return;

		if (node.data == data) {
			if (left != '.')
				node.left = new TreeNode(left);
			if (right != '.')
				node.right = new TreeNode(right);
		} else {
			next(node.left, data, left, right);
			next(node.right, data, left, right);
		}
	}

	// ���� ��ȸ, ��Ʈ -> ���� -> ������
	public void preOrder(TreeNode node) {
		System.out.print(node.data);
		if (node.left != null)
			preOrder(node.left);
		if (node.right != null)
			preOrder(node.right);
	}

	// ���� ��ȸ, ���� -> ��Ʈ -> ������
	public void inOrder(TreeNode node) {
		if (node.left != null)
			inOrder(node.left);
		System.out.print(node.data);
		if (node.right != null)
			inOrder(node.right);
	}

	// ���� ��ȸ, ���� -> ������ -> ��Ʈ 
	public void postOrder(TreeNode node) {
		if (node.left != null)
			postOrder(node.left);
		if (node.right != null)
			postOrder(node.right);
		System.out.print(node.data);
	}
}