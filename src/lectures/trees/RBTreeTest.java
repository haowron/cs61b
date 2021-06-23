package lectures.trees;

import org.junit.Test;

import static org.junit.Assert.*;

public class RBTreeTest {
    private RBTree<Integer> generateTree() {
        RBTree<Integer> rb_tree = new RBTree<>();
        for (int i = 1; i < 30; i = i + 3) {
            rb_tree.insert(i);
        }
        return rb_tree;
    }

    @Test
    public void testInsert() {
        RBTree<Integer> t = generateTree();
        assertEquals(10, (int) t.root.data);
        assertEquals('B', t.root.color);
        assertEquals(4, (int) t.root.left.data);
        assertEquals('B', t.root.left.color);
        assertEquals(1, (int) t.root.left.left.data);
        assertEquals('B', t.root.left.left.color);
        assertEquals(7, (int) t.root.left.right.data);
        assertEquals('B', t.root.left.right.color);
        assertEquals(16, (int) t.root.right.data);
        assertEquals('B', t.root.right.color);
        assertEquals(13, (int) t.root.right.left.data);
        assertEquals('B', t.root.right.left.color);
        assertEquals(22, (int) t.root.right.right.data);
        assertEquals('R', t.root.right.right.color);
        assertEquals(19, (int) t.root.right.right.left.data);
        assertEquals('B', t.root.right.right.left.color);
        assertEquals(25, (int) t.root.right.right.right.data);
        assertEquals('B', t.root.right.right.right.color);
        assertEquals(28, (int) t.root.right.right.right.right.data);
        assertEquals('R', t.root.right.right.right.right.color);
    }
}
