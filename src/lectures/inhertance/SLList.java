package lectures.inhertance;

public class SLList<Item> implements List61B<Item> {
    private class ItemNode {
        Item value;
        ItemNode next;


        public ItemNode(Item v) {
            value = v;
            next = null;
        }

        public ItemNode(Item v, ItemNode n) {
            value = v;
            next = n;
        }
    }

    ItemNode sentinel = new ItemNode(null);

    @Override
    public void addFirst(Item x) {
        sentinel.next = new ItemNode(x, sentinel.next);
    }

    @Override
    public void addLast(Item x) {
        ItemNode n = sentinel;
        while (n.next != null) {
            n = n.next;
        }
        n.next = new ItemNode(x);
    }

    @Override
    public Item getFirst() {
        if (sentinel.next == null) {
            return null;
        }
        return sentinel.next.value;
    }

    @Override
    public Item getLast() {
        ItemNode n = sentinel;
        while (n.next != null) {
            n = n.next;
        }
        return n.value;
    }

    @Override
    public Item removeLast() throws Exception {
        ItemNode n = sentinel;
        if (n.next == null) {
            throw new Exception("The list is empty.");
        }
        while (n.next.next != null) {
            n = n.next;
        }
        ItemNode last_node = n.next;
        n.next = null;
        return last_node.value;
    }

    @Override
    public Item get(int i) throws Exception {
        if (sentinel.next == null) {
            throw new Exception("This list is empty");
        }
        ItemNode n = sentinel.next;
        while (i != 0 && n != null) {
            --i;
            n = n.next;
        }
        if (n == null) {
            throw new Exception("Out of range.");
        }
        return n.value;
    }

    @Override
    public void insert(Item x, int position) throws Exception {
        ItemNode n = sentinel.next;
        while (position != 0 && n != null) {
            --position;
            n = n.next;
        }
        if (n == null) {
            throw new Exception("Out of range.");
        }
        n.next = new ItemNode(x, n.next);
    }

    @Override
    public int size() {
        int s = 0;
        ItemNode n = sentinel;
        while (n.next != null) {
            ++s;
        }
        return s;
    }

    @Override
    public String toString() {
        if (sentinel.next == null) return "[]";
        StringBuilder sb = new StringBuilder("[");
        ItemNode n = sentinel.next;
        while (n.next != null) {
            sb.append(n.value).append(", ");
            n = n.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        List61B<String> someList = new SLList<String>();
        someList.addFirst("elk");
    }
}

