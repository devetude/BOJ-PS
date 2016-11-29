package boj_1991;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 백준 온라인 저지 1991번 (트리 순회) 문제풀이
 *
 * @see https://www.acmicpc.net/problem/1991
 * @author devetude
 */
public class Main {
	// 개행 문자열 상수
	private static final String NEW_LINE = "\n";

	public static void main(String args[]) throws Exception {
		// 버퍼를 통해 입력 값을 받음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, BinaryTree> binaryTree = new HashMap<>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			// 이진 트리를 만듬
			binaryTree.put(st.nextToken(), new BinaryTree(st.nextToken(), st.nextToken()));
		}

		br.close();

		// 결과 값을 저장 할 버퍼 객체 변수 초기화
		StringBuilder sb = new StringBuilder();

		// 전위우선순회 결과 값을 버퍼를 통해 만듬
		preorderTraversal("A", binaryTree, sb);
		sb.append(NEW_LINE);

		// 중위우선순회 결과 값을 버퍼를 통해 만듬
		inorderTraversal("A", binaryTree, sb);
		sb.append(NEW_LINE);

		// 후위우선순회 결과 값을 버퍼를 통해 만듬
		postorderTraversal("A", binaryTree, sb);

		// 결과 값 출력
		System.out.println(sb.toString());
	}

	/**
	 * 이진 트리 이너 클래스
	 * 
	 * @author devetude
	 */
	private static class BinaryTree {
		// 오른쪽과 왼쪽 노드 값 변수
		public String leftNode;
		public String rightNode;

		/**
		 * 생성자
		 * 
		 * @param leftNode
		 * @param rightNode
		 */
		public BinaryTree(String leftNode, String rightNode) {
			this.leftNode = leftNode;
			this.rightNode = rightNode;
		}
	}

	/**
	 * 전위우선순회 메소드
	 * 
	 * @param value
	 * @param binaryTree
	 * @param sb
	 */
	private static void preorderTraversal(String value, HashMap<String, BinaryTree> binaryTree, StringBuilder sb) {
		BinaryTree node = binaryTree.get(value);

		if (node != null) {
			// 루트 > 왼쪽 > 오른쪽 순서
			sb.append(value);
			preorderTraversal(node.leftNode, binaryTree, sb);
			preorderTraversal(node.rightNode, binaryTree, sb);
		}
	}

	/**
	 * 중위우선순회 메소드
	 * 
	 * @param value
	 * @param binaryTree
	 * @param sb
	 */
	private static void inorderTraversal(String value, HashMap<String, BinaryTree> binaryTree, StringBuilder sb) {
		BinaryTree node = binaryTree.get(value);

		if (node != null) {
			// 왼쪽 > 루트 > 오른쪽 순서
			inorderTraversal(node.leftNode, binaryTree, sb);
			sb.append(value);
			inorderTraversal(node.rightNode, binaryTree, sb);
		}
	}

	/**
	 * 후위우선순회 메소드
	 * 
	 * @param value
	 * @param binaryTree
	 * @param sb
	 */
	private static void postorderTraversal(String value, HashMap<String, BinaryTree> binaryTree, StringBuilder sb) {
		BinaryTree node = binaryTree.get(value);

		if (node != null) {
			// 왼쪽 > 오른쪽 > 루트 순서
			postorderTraversal(node.leftNode, binaryTree, sb);
			postorderTraversal(node.rightNode, binaryTree, sb);
			sb.append(value);
		}
	}
}