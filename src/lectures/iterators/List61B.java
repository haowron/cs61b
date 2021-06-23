package lectures.iterators;

public interface List61B<Item> {
    public void addFirst(Item x);

    public void addLast(Item x);

    public Item getFirst();

    public Item getLast();

    public Item removeLast() throws Exception;

    public Item get(int i) throws Exception;

    // 在index position 之后插入Item x
    public void insert(Item x, int position) throws Exception;

    public int size();

    public String toString();

    public boolean equals(Object x);

    public int hashCode();
}
