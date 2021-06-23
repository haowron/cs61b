package lectures.disjointsets;

public interface iDisjointSets {
    public boolean isConnected(int a, int b);

    public void connect(int a, int b);
}
