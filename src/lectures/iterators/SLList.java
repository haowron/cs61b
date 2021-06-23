package lectures.iterators;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class SLList<Item> implements List61B<Item>, Iterable<Item> {
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

    private class SLListIterator implements Iterator<Item> {
        ItemNode n = sentinel;

        public boolean hasNext() {
            return n.next != null;
        }

        public Item next() {
            n = n.next;
            return n.value;
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

    /* insert item x after index x */
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
            n = n.next;
        }
        return s;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        ItemNode n = sentinel;
        while (n.next != null) {
            n = n.next;
            sb.append(n.value).append(", ");
        }
        sb = sb.replace(sb.length() - 2, sb.length(), "]");
        return sb.toString();
    }

    @NotNull
    public Iterator<Item> iterator() {
        return new SLListIterator();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o == this) return true;
        if (o.getClass() != this.getClass()) return false;
        ItemNode n1 = sentinel;
        ItemNode n2 = ((SLList<Item>) o).sentinel;

        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) return false;
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1 == null && n2 == null;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        for (Item i : this) {
            hash = 31 * hash + (i == null ? 0 : i.hashCode());
        }
        return hash;
    }


    public static void main(String[] args) {
        SLList<Integer> l1 = new SLList<>();
        l1.addLast(3);
        l1.addLast(4);
        l1.addLast(5);
        SLList<Integer> l2 = new SLList<>();
        l2.addFirst(5);
        l2.addFirst(4);
        l2.addFirst(3);
        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l1 == l2);
    }
}

