package lectures.lists;

public class SLLists {
    private static class IntNode {
        int value;
        IntNode next;

        public IntNode() {
            value = 0;
            next = null;
        }

        public IntNode(int v) {
            value = v;
            next = null;
        }

        public IntNode(int v, IntNode n) {
            value = v;
            next = n;
        }
    }

    IntNode sentinel = new IntNode();
    int size = 0;

    public SLLists() {
    }

    public SLLists(int v) {
        size += 1;
        sentinel.next = new IntNode(v);
    }

    public void addFirst(int v) {
        size += 1;
        IntNode n = new IntNode();
        n.next = sentinel;
        sentinel.value = v;
        sentinel = n;
    }

    public void addLast(int v) {
        size += 1;
        IntNode last_node = sentinel;
        while (last_node.next != null) {
            last_node = last_node.next;
        }
        last_node.next = new IntNode(v);
    }

    public String toString() {
        IntNode n = sentinel.next;
        StringBuilder sb = new StringBuilder();
        while (n != null) {
            sb.append(n.value).append(" ");
            n = n.next;
        }
        return sb.substring(0, sb.length() - 1);
    }

    public static void main(String[] args) {
        SLLists l = new SLLists();
        System.out.println(l.size);
        l = new SLLists(3);
        l.addFirst(2);
        l.addLast(4);
        System.out.println(l.size);
        System.out.println(l);
    }
}

