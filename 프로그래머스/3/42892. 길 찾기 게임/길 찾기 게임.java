import java.util.*;

class Loc {
    int value;
    int x;
    int y;

    Loc left;
    Loc right;

    public Loc(int value, int x, int y) {
        this.value = value;
        this.x= x;
        this.y = y;
    }
}

class Solution {
    static Loc root;
    static int index = 0;
    public int[][] solution(int[][] nodeinfo) {
        int N = nodeinfo.length;
        int[][] answer = new int[2][N];

        List<Loc> locList = new ArrayList<>();
        for(int n=1;n<=N;n++) {
            Loc loc = new Loc(n, nodeinfo[n-1][0], nodeinfo[n-1][1]);
            locList.add(loc);
        }

        Collections.sort(locList, new Comparator<Loc>() {
            @Override
            public int compare(Loc o1, Loc o2) {
                if (o1.y == o2.y) {
                    return o1.x - o2.x; // y가 같으면 x 오름차순
                }
                return o2.y - o1.y; // y 기준 내림차순
            }
        });

        root = locList.get(0);
        for(int i=1;i<N;i++) {
            Loc nowLoc = locList.get(i);
            addNode(root, nowLoc);
        }

        int[] pre = new int[N];
        index = 0;
        preOrder(root, pre);

        int[] post = new int[N];
        index = 0;
        postOrder(root, post);

        answer[0] = pre;
        answer[1] = post;
        return answer;
    }
    
    // 노드 연결
    static void addNode(Loc pLoc, Loc cLoc) {
        if(cLoc.x<pLoc.x) {
            if(pLoc.left == null) {
                pLoc.left = cLoc;
            } else {
                addNode(pLoc.left, cLoc);
            }
        } else {
            if(pLoc.right == null) {
                pLoc.right = cLoc;
            } else {
                addNode(pLoc.right, cLoc);
            }
        }
    }

    // 전위 순회 (root -> left -> right
    static void preOrder(Loc root, int[] pre) {
        if(root == null) {
            return;
        }
        pre[index] = root.value;
        index++;
        preOrder(root.left, pre);
        preOrder(root.right, pre);
    }

    // 후위 순회 (left -> right -> root)
    static void postOrder(Loc root, int[] post) {
        if(root == null) {
            return;
        }
        postOrder(root.left, post);
        postOrder(root.right, post);
        post[index] = root.value;
        index++;
    }
}