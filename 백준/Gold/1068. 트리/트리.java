

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Nnode {
    int value;
    List<Nnode> childList;
    public Nnode(int value) {
        this.value = value;
        this.childList = new ArrayList<>();
    }
}

public class Main {
    static Nnode root;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<List<Integer>> tree = new ArrayList<>();
        for(int i=0;i<N;i++) {
            tree.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int c=0;c<N;c++) {
            int p = Integer.parseInt(st.nextToken());
            if(p==-1) {
                root = new Nnode(c);
            } else {
                tree.get(p).add(c);
            }
        }

        int removeTarget = Integer.parseInt(br.readLine());
        if(removeTarget == root.value) {
            System.out.println(count);
        } else {
            connect(root, tree, removeTarget);
            dfs(root);
            System.out.println(count);
        }
    }

    static void connect(Nnode pNode, List<List<Integer>> tree, int removeTarget){
        for(int child: tree.get(pNode.value)) {
            if(child == removeTarget) {
                continue;
            }
            Nnode cNode = new Nnode(child);
            pNode.childList.add(cNode);
            connect(cNode, tree, removeTarget);
        }
    }

    static void dfs(Nnode node) {
        if(node.childList.isEmpty()) {
            count++;
            return;
        }
        for(Nnode cNode: node.childList) {
            dfs(cNode);
        }
    }
}
