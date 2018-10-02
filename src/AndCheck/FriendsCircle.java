package AndCheck;

public class FriendsCircle {
    public int findCircleNum(int[][] M) {
        int count = 0;
        int n = M.length;
        if (n == 0) return count;
        int s[] = new int[n];//每个结点的父节点
        //初始化
        count = n;
        for (int i = 0; i < n; i++)//每个结点的父节点都是他自己，自成一个朋友圈。
            s[i] = i;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)

//                并查集实现方式一：按照正常的树的形式一层一层地找。
                // 并查集实现方式二：树只有两层，所有的非根子节点的父节点都是指向根结点的
                if(M[i][j]==1&&find2(i,s)!=find2(j,s)){
                     union(i,j,s);
                     count--;
                }
                return count;
    }

    public int find2(int i, int s[]) {
        if (s[i] != i) {
            s[i] = find(s[i], s);
        }
        return s[i];
    }

    public int find(int i, int s[]) {
        while (s[i] != i) {
            i=s[i];
        }
        return s[i];
    }

    public void union(int i, int j, int s[]) {
        s[find(j, s)] = find(i, s);
    }
}
