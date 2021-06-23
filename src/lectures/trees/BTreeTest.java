package lectures.trees;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;

public class BTreeTest {

    private BTree<Integer> setUpBTree() throws Exception {
        BTree<Integer> b = new BTree<>();
        for (int i = 1; i < 41; i = i + 3) {
            b.insert(i);
        }
        return b;
    }

    @Test
    public void insertTest() throws Exception {
        BTree<Integer> b = setUpBTree();
        b.insert(2);
        assertEquals(2, b.root.size);
        assertEquals(Arrays.asList(10, 22), b.root.key);
        assertEquals(1, b.root.child.get(0).size);
        assertEquals(4, (int) b.root.child.get(0).key.get(0));
        assertEquals(2, b.root.child.get(0).child.get(0).size);
        assertEquals(Arrays.asList(1, 2), b.root.child.get(0).child.get(0).key);
        assertEquals(7, (int) b.root.child.get(0).child.get(1).key.get(0));
        assertEquals(1, b.root.child.get(1).size);
        assertEquals(16, (int) b.root.child.get(1).key.get(0));
        assertEquals(1, b.root.child.get(1).child.get(0).size);
        assertEquals(13, (int) b.root.child.get(1).child.get(0).key.get(0));
        assertEquals(19, (int) b.root.child.get(1).child.get(1).key.get(0));
        assertEquals(2, b.root.child.get(2).size);
        assertEquals(Arrays.asList(28, 34), b.root.child.get(2).key);
        assertEquals(1, b.root.child.get(2).child.get(0).size);
        assertEquals(25, (int) b.root.child.get(2).child.get(0).key.get(0));
        assertEquals(1, b.root.child.get(2).child.get(1).size);
        assertEquals(31, (int) b.root.child.get(2).child.get(1).key.get(0));
        assertEquals(2, b.root.child.get(2).child.get(2).size);
        assertEquals(Arrays.asList(37, 40), b.root.child.get(2).child.get(2).key);
    }

    @Test(expected = Exception.class)
    public void insertSameValueExceptionTest() throws Exception {
        BTree<Integer> b = setUpBTree();
        b.insert(1);
    }
}
