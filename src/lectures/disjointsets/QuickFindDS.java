package lectures.disjointsets;

public class QuickFindDS implements iDisjointSets {
    private int[] ids;
    private int length;

    public QuickFindDS(int N) {
        length = N;
        ids = new int[N];
        for (int i = 0; i < N; ++i) {
            ids[i] = i;
        }
    }

    @Override
    public boolean isConnected(int a, int b) {
        return ids[a] == ids[b];
    }

    @Override
    public void connect(int a, int b) {
        int aid = ids[a];
        int bid = ids[b];
        for (int i = 0; i < length; ++i) {
            if (ids[i] == aid) ids[i] = bid;
        }
    }
}
