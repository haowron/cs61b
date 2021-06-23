package lectures.trees;

import java.util.ArrayList;
import java.util.List;

public class BTree<Item extends Comparable<Item>> {
    public class BTNode<Item> {
        public BTNode<Item> parent;
        public List<BTNode<Item>> child;
        public List<Item> key;
        final int ORDER = 3;
        public int size;

        public BTNode() {
            key = new ArrayList<>();
            child = new ArrayList<>();
            size = 0;
        }

        public BTNode(Item x) {
            key = new ArrayList<>();
            child = new ArrayList<>();
            key.add(x);
            size = 1;
        }

        public BTNode(Item x, BTNode<Item> p) {
            parent = p;
            key = new ArrayList<>();
            child = new ArrayList<>();
            key.add(x);
            size = 1;
        }


        public BTNode(Item x, BTNode<Item> p, BTNode<Item> l, BTNode<Item> r) {
            key = new ArrayList<>();
            child = new ArrayList<>();
            parent = p;
            key.add(x);
            child.add(l);
            child.add(r);
            l.parent = this;
            r.parent = this;
            size = 1;
        }
    }

    public BTNode<Item> root;

    public BTree() {
        root = new BTNode<>();
    }

    public BTree(Item x) {
        root = new BTNode<>(x);
    }

    private void solveOverflow(BTNode<Item> n) {
        if (n.size < 3) return;
        if (n == root) {
            if (n.child.isEmpty()) {
                root = new BTNode<>(n.key.get(1), null, new BTNode<>(n.key.get(0)), new BTNode<>(n.key.get(2)));
            } else {
                root = new BTNode<>(n.key.get(1), null, new BTNode<>(n.key.get(0), null, n.child.get(0), n.child.get(1)), new BTNode<>(n.key.get(2), null, n.child.get(2), n.child.get(3)));
            }
        } else {
            int p = n.parent.size;
            for (int i = 0; i < n.parent.size; ++i) {
                if (n.key.get(1).compareTo(n.parent.key.get(i)) < 0) {
                    p = i;
                    break;
                }
            }
            n.parent.key.add(p, n.key.get(1));
            if (n.child.isEmpty()) {
                n.parent.child.set(p, new BTNode<>(n.key.get(0), n.parent));
                n.parent.child.add(p + 1, new BTNode<>(n.key.get(2), n.parent));
            } else {
                n.parent.child.set(p, new BTNode<>(n.key.get(0), n.parent, n.child.get(0), n.child.get(1)));
                n.parent.child.add(p + 1, new BTNode<>(n.key.get(2), n.parent, n.child.get(2), n.child.get(3)));
            }
            ++n.parent.size;
            solveOverflow(n.parent);
        }
    }

    public void solveUnderflow(BTNode<Item> n) {
        if (n.size > 0) {
            return;
        }
        if (n.parent == null){
            return;
        }

        int p;
        for (p = 0; p < n.parent.size + 1; ++p) {
            if (n.parent.child.get(p) == n) {
                break;
            }
        }

        solveUnderflow(n.parent);
    }

    public Item search(Item x) {
        return search(x, root);
    }

    private Item search(Item x, BTNode<Item> b) {
        if (b == null) {
            return null;
        }
        for (int i = 0; i < b.size; ++i) {
            if (x.compareTo(b.key.get(i)) < 0) {
                return search(x, b.child.get(i));
            } else if (x == b.key.get(i)) {
                return x;
            }
        }
        return search(x, b.child.get(b.size));
    }

    public Item insert(Item x) throws Exception {
        BTNode<Item> n = root;
        int p;
        while (!n.child.isEmpty()) {
            p = n.size;
            for (int i = 0; i < n.size; ++i) {
                if (x == n.key.get(i)) {
                    throw new Exception();
                } else if (x.compareTo(n.key.get(i)) < 0) {
                    p = i;
                    break;
                }
            }
            n = n.child.get(p);
        }
        p = n.size;
        for (int i = 0; i < n.size; ++i) {

            if (x == n.key.get(i)) {
                throw new Exception();
            } else if (x.compareTo(n.key.get(i)) < 0) {
                p = i;
                break;
            }
        }
        n.key.add(p, x);
        ++n.size;
        solveOverflow(n);
        return x;
    }
}
