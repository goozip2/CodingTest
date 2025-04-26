

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    char value;
    Node left;
    Node right;
    public Node(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class Main {
    static Node root = new Node('A');
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Character, List<Character>> map = new HashMap<>();
        for(int n=0;n<N;n++){
            String[] sArr = br.readLine().split(" ");
            char tempValue = sArr[0].charAt(0);
            List<Character> tempList = new ArrayList<>();
            tempList.add(sArr[1].charAt(0));
            tempList.add(sArr[2].charAt(0));
            map.put(tempValue, tempList);
        }

        connect(root, map);

        preOrder(root);
        sb.append("\n");
        inOrder(root);
        sb.append("\n");
        postOrder(root);

        System.out.println(sb);
    }

    static void connect(Node node, Map<Character, List<Character>> map) {
        if(map.get(node.value).get(0) != '.') {
            node.left = new Node(map.get(node.value).get(0));
            connect(node.left, map);
        }
        if(map.get(node.value).get(1) != '.') {
            node.right = new Node(map.get(node.value).get(1));
            connect(node.right, map);
        }
        return;
    }

    // 전위 순회: 루트 -> 왼 -> 오
    static void preOrder(Node node) {
        if(node == null) {
            return;
        }
        sb.append(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    // 중위 순회: 왼 -> 루트 -> 오
    static void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        sb.append(node.value);
        inOrder(node.right);
    }

    // 후위 순회: 왼 -> 오 -> 루트
    static void postOrder(Node node) {
        if(node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.value);
    }
}
