package lectures.inhertance;

public class DLList<Item> {
    public class Node {
        Item value = null;
        Node prev = null;
        Node next = null;

        public Node() {
        }

        public Node(Item v) {
            value = v;
        }

        public Node(Node p, Node n) {
            prev = p;
            next = n;
        }

        public Node(Item v, Node p, Node n) {
            value = v;
            prev = p;
            next = n;
        }
    }

    Node sentinel = new Node();
    int size = 0;

    public DLList() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public DLList(Item v) {
        size += 1;
        Node n = new Node(v, sentinel, sentinel);
        sentinel.next = n;
        sentinel.prev = n;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item v) {
        size += 1;
        Node n = new Node(v, sentinel, sentinel.next);
        sentinel.next = n;
        n.next.prev = n;
    }

    public void addLast(Item v) {
        size += 1;
        Node n = new Node(v, sentinel.prev, sentinel);
        sentinel.prev = n;
        n.prev.next = n;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node n = sentinel;
        while (n.next.next != sentinel) {
            n = n.next;
            sb.append(n.value).append(" ");
        }
        if (n.next.value != null) {
            sb.append(n.next.value);
        }
        sb.append("]");
        return sb.toString();
    }

    public Item removeFirst() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        Node n = sentinel.next;
        n.prev.next = n.next;
        n.next.prev = n.prev;
        return n.value;
    }

    public Item removeLast() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        Node n = sentinel.prev;
        n.prev.next = n.next;
        n.next.prev = n.prev;
        return n.value;
    }

    public Item get(int index) {
        if (index > size) return null;
        Node n = sentinel;
        for (int i = 0; i < index; ++i) {
            n = n.next;
        }
        return n.value;
    }

    public static void main(String[] args) {
    }
}

