package lectures.trees;

import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTree<Item extends Comparable<Item>> implements iBST<Item> {
    private class Node<Item extends Comparable<Item>> {
        public Item data;
        public Node<Item> left_child;
        public Node<Item> right_child;

        public Node() {
        }

        public Node(Item d) {
            data = d;
        }

        public Node(Item d, Node<Item> p, Node<Item> l, Node<Item> r) {
            data = d;
            left_child = l;
            right_child = r;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null) return false;
            if (this.getClass() != o.getClass()) return false;
            Node<Item> o_ = (Node<Item>) o;
            return o_.data == data;
        }

        @Override
        public int hashCode() {
            return data.hashCode();
        }
    }

    public Node<Item> root;

    public BinarySearchTree() {
        root = null;
    }

    @Override
    public Item insert(Item x) throws Exception {
        root = insert(x, root);
        return x;
    }

    private Node<Item> insert(Item x, Node<Item> n) throws Exception {
        if (n == null) {
            return new Node<Item>(x);
        } else if (x.compareTo(n.data) < 0) {
            n.left_child = insert(x, n.left_child);
        } else if (x.compareTo(n.data) > 0) {
            n.right_child = insert(x, n.right_child);
        } else {
            throw new Exception("Item:" + x + " has been stored in this tree");
        }
        return n;
    }

    @Override
    public Item delete(Item x) {
        Node<Item> d = delete(x, root);
        if (d == null) {
            return null;
        }
        return d.data;
    }

    private Node<Item> delete(Item x, Node<Item> n) {
        if (n == null) {
            return null;
        }
        if (x.compareTo(n.data) < 0) {
            n.left_child = delete(x, n.left_child);

        } else if (x.compareTo(n.data) > 0) {
            n.right_child = delete(x, n.right_child);
        } else {
            if (n.left_child == null && n.right_child == null) {
                return null;
            } else if (n.right_child == null) {
                return n.left_child;
            } else if (n.left_child == null) {
                return n.right_child;
            } else {
                Node<Item> r = n.left_child;
                while (r.right_child != null) {
                    r = r.right_child;
                }
                n.data = r.data;
                n.left_child = delete(r.data, n.left_child);
                return n;
            }
        }
        return n;
    }

    @Override
    public Item find(Item x) {
        Node<Item> d = find(x, root);
        if (d == null) {
            return null;
        }
        return d.data;
    }

    private Node<Item> find(Item x, Node<Item> n) {
        if (n == null) {
            return null;
        } else if (x.compareTo(n.data) < 0) {
            return find(x, n.left_child);
        } else if (x.compareTo(n.data) > 0) {
            return find(x, n.right_child);
        } else {
            return n;
        }
    }

    private class preIterator implements Iterator<Item> {
        Stack<Node<Item>> nodeStack;

        public preIterator() {
            nodeStack = new Stack<>();
            nodeStack.push(root);
        }


        @Override
        public boolean hasNext() {
            return !nodeStack.isEmpty();
        }

        @Override
        public Item next() {
            Node<Item> n = nodeStack.pop();
            if (n.right_child != null) {
                nodeStack.push(n.right_child);
            }
            if (n.left_child != null) {
                nodeStack.push(n.left_child);
            }
            return n.data;
        }
    }

    private class inIterator implements Iterator<Item> {
        Stack<Node<Item>> nodeStack;

        public inIterator() {
            Node<Item> n = root;
            nodeStack = new Stack<>();
            while (n != null) {
                nodeStack.push(n);
                n = n.left_child;
            }
        }


        @Override
        public boolean hasNext() {
            return !nodeStack.isEmpty();
        }

        @Override
        public Item next() {
            Node<Item> n = nodeStack.pop();
            Item d = n.data;
            if (n.right_child != null) {
                n = n.right_child;
                while (n != null) {
                    nodeStack.push(n);
                    n = n.left_child;
                }
            }
            return d;
        }
    }

    private class postIterator implements Iterator<Item> {
        Node<Item> preNode;
        Stack<Node<Item>> nodeStack;

        public postIterator() {
            Node<Item> n = root;
            nodeStack = new Stack<>();
            while (true) {
                nodeStack.push(n);
                if (n.left_child != null) {
                    n = n.left_child;
                } else if (n.right_child != null) {
                    n = n.right_child;
                } else {
                    break;
                }
            }
        }


        @Override
        public boolean hasNext() {
            return !nodeStack.isEmpty();
        }

        @Override
        public Item next() {
            Node<Item> n = nodeStack.peek();
            // 如果当前节点有两个节点，而且上一个节点是左节点的情况下加入右节点。
            // 单节点情况已经入栈
            if (n.left_child != null && n.right_child != null && preNode == n.left_child) {
                n = n.right_child;
                while (true) {
                    nodeStack.push(n);
                    if (n.left_child != null) {
                        n = n.left_child;
                    } else if (n.right_child != null) {
                        n = n.right_child;
                    } else {
                        break;
                    }
                }
            }
            preNode = nodeStack.pop();
            return preNode.data;
        }
    }

    @Override
    public Iterator<Item> travelPre() {
        return new preIterator();
    }

    @Override
    public Iterator<Item> travelIn() {
        return new inIterator();
    }

    @Override
    public Iterator<Item> travelPost() {
        return new postIterator();
    }
}
