package lectures.disjointsets;

import java.util.ArrayList;

public class WeightedQuickUnionDS implements iDisjointSets {
    private int[] parent;
    private int[] weight;

    public WeightedQuickUnionDS(int N) {
        parent = new int[N];
        weight = new int[N];
        for (int i = 0; i < N; ++i) {
            parent[i] = -1;
            weight[i] = 0;
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
        // path compression
        ArrayList<Integer> l = new ArrayList<>();
        while (parent[a] != -1) {
            l.add(a);
            a = parent[a];
        }
        for (int i : l) {
            parent[i] = a;
            weight[i] = 1;
        }
        return a;
    }
}
