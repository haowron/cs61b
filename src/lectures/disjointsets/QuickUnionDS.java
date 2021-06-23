package lectures.disjointsets;


public class QuickUnionDS implements iDisjointSets {
    private int[] parent;

    public QuickUnionDS(int N) {
        parent = new int[N];
        for (int i = 0; i < N; ++i) {
            parent[i] = -1;
        }
    }

    @Override
    public boolean isConnected(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        return pa == pb;
    }

    @Override
    public void connect(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        parent[pa] = pb;
    }

    private int find(int a) {
        while (parent[a] != -1) {
            a = parent[a];
        }
        return a;
    }
}
