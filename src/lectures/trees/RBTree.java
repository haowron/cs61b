package lectures.trees;

public class RBTree<Item extends Comparable<Item>> {
    public class RBNode<Item> {
        public char color;
        public Item data;
        public RBNode<Item> parent;
        public RBNode<Item> left;
        public RBNode<Item> right;

        public RBNode() {
            data = null;
            color = 'B';
            parent = null;
            left = null;
            right = null;
        }

        public RBNode(Item d) {
            data = d;
            color = 'R';
        }

        public void left_rotate() {
            if (parent != sentinel) {
                if (this == parent.left) {
                    parent.left = right;
                } else {
                    parent.right = right;
                }
            }
            RBNode<Item> rl = right.left;
            right.parent = parent;
            right.left = this;

            parent = right;
            right = rl;
            if (rl != sentinel) {
                rl.parent = this;
            }
        }

        public void right_rotate() {
            if (parent != sentinel) {
                if (this == parent.left) {
                    parent.left = left;
                } else {
                    parent.right = left;
                }
            }
            RBNode<Item> lr = left.right;
            left.parent = parent;
            left.right = this;

            parent = left;

            left = lr;
            if (lr != sentinel) {
                lr.parent = this;
            }

        }
    }

    RBNode<Item> root;
    RBNode<Item> sentinel = new RBNode<>();

    public RBTree() {
        root = sentinel;
    }

    private void insert_fix_up(RBNode<Item> d) {
        while (d.parent.color == 'R') {
            if (d.parent == d.parent.parent.left) {
                RBNode<Item> u = d.parent.parent.right;
                if (u.color == 'R') {
                    u.color = 'B';
                    d.parent.color = 'B';
                    u.parent.color = 'R';
                    d = d.parent.parent;
                } else {
                    if (d == d.parent.right) {
                        d = d.parent;
                        d.left_rotate();
                    }
                    d.parent.color = 'B';
                    d.parent.parent.color = 'R';
                    d.parent.parent.right_rotate();
                }
            } else {
                RBNode<Item> u = d.parent.parent.left;
                if (u.color == 'R') {
                    u.color = 'B';
                    d.parent.color = 'B';
                    u.parent.color = 'R';
                    d = d.parent.parent;
                } else {
                    if (d == d.parent.left) {
                        d = d.parent;
                        d.right_rotate();
                    }
                    d.parent.color = 'B';
                    d.parent.parent.color = 'R';
                    d.parent.parent.left_rotate();
                }
            }

        }
        while (d.parent != sentinel) {
            d = d.parent;
        }
        root = d;
        root.color = 'B';
    }

    private RBNode<Item> new_node(Item d) {
        RBNode<Item> n = new RBNode<>(d);
        n.parent = sentinel;
        n.left = sentinel;
        n.right = sentinel;
        return n;
    }

    private RBNode<Item> new_node(Item d, RBNode<Item> p) {
        RBNode<Item> n = new RBNode<>(d);
        n.parent = p;
        n.left = sentinel;
        n.right = sentinel;
        return n;
    }

    private RBNode<Item> new_node(Item d, RBNode<Item> p, RBNode<Item> l, RBNode<Item> r) {
        RBNode<Item> n = new RBNode<>(d);
        n.parent = p;
        n.left = l;
        n.right = r;
        return n;
    }

    private void transplant(RBNode<Item> u, RBNode<Item> v) {
        if (u.parent == sentinel) {
            root = v;
        } else if (u == u.parent.left) {
            u.parent.left = v;
        } else {
            u.parent.right = v;
        }
        v.parent = u.parent;
    }


    public boolean insert(Item d) {
        RBNode<Item> y_ = root;
        RBNode<Item> y = sentinel;
        while (y_ != sentinel) {
            y = y_;
            if (y_.data == d) {
                return false;
            } else if (d.compareTo(y_.data) < 0) {
                y_ = y_.left;
            } else {
                y_ = y_.right;
            }
        }
        RBNode<Item> node_ = new_node(d);
        if (y == sentinel) {
            root = node_;
        } else if (d.compareTo(y.data) < 0) {
            y.left = node_;
            node_.parent = y;
        } else {
            y.right = node_;
            node_.parent = y;
        }
        insert_fix_up(node_);
        return true;
    }

    public Item delete(Item d) {
        RBNode<Item> n = root;
        while (n != sentinel) {
            if (d == n.data) {
                if (n.left == sentinel) {
                    transplant(n, n.right);
                } else if (n.right == sentinel) {
                    transplant(n, n.left);
                } else {
                    RBNode<Item> prev_node = n.left;
                    while (prev_node.right != sentinel) {
                        prev_node = prev_node.right;
                    }
                    transplant(n, prev_node);
                    transplant(prev_node, prev_node.left);
                }
            } else if (d.compareTo(n.data) < 0) {
                n = n.left;
            } else {
                n = n.right;
            }
        }
        return null;
    }
}
