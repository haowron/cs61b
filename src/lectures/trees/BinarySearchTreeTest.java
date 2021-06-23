package lectures.trees;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    private List<Integer> toList(Iterator<Integer> i) {
        List<Integer> l = new ArrayList<>();
        while (i.hasNext()) {
            l.add(i.next());
        }
        return l;
    }

    private BinarySearchTree<Integer> setUpTree() throws Exception {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(3);
        bst.insert(5);
        bst.insert(2);
        bst.insert(7);
        bst.insert(4);
        bst.insert(1);
        bst.insert(6);
        bst.insert(9);
        bst.insert(8);
        return bst;
    }


    @Test(expected = Exception.class)
    public void BSTInsertErrorTest() throws Exception {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(3);
        bst.insert(5);
        bst.insert(2);
        bst.insert(2);
    }

    @Test
    public void BSTFindTest() throws Exception {
        BinarySearchTree<Integer> bst = setUpTree();
        assertNull(bst.find(14));
        assertEquals(5, (int) bst.find(5));
        assertEquals(3, (int) bst.find(3));
    }

    @Test
    public void BSTTravelTest() throws Exception {
        BinarySearchTree<Integer> bst = setUpTree();

        Integer[] expected_pre = {3, 2, 1, 5, 4, 7, 6, 9, 8};
        assertEquals(Arrays.asList(expected_pre), toList(bst.travelPre()));

        Integer[] expected_in = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertEquals(Arrays.asList(expected_in), toList(bst.travelIn()));

        Integer[] expected_post = {1, 2, 4, 6, 8, 9, 7, 5, 3};
        assertEquals(Arrays.asList(expected_post), toList(bst.travelPost()));
    }

    @Test
    public void BSTDeleteLeafTest() throws Exception {
        BinarySearchTree<Integer> bst = setUpTree();
        bst.delete(6);

        Integer[] expected_pre = {3, 2, 1, 5, 4, 7, 9, 8};
        assertEquals(Arrays.asList(expected_pre), toList(bst.travelPre()));

        Integer[] expected_in = {1, 2, 3, 4, 5, 7, 8, 9};
        assertEquals(Arrays.asList(expected_in), toList(bst.travelIn()));

        Integer[] expected_post = {1, 2, 4, 8, 9, 7, 5, 3};
        assertEquals(Arrays.asList(expected_post), toList(bst.travelPost()));
    }

    @Test
    public void BSTDeleteOneChildTest() throws Exception {
        BinarySearchTree<Integer> bst = setUpTree();
        bst.delete(9);

        Integer[] expected_pre = {3, 2, 1, 5, 4, 7, 6, 8};
        assertEquals(Arrays.asList(expected_pre), toList(bst.travelPre()));

        Integer[] expected_in = {1, 2, 3, 4, 5, 6, 7, 8};
        assertEquals(Arrays.asList(expected_in), toList(bst.travelIn()));

        Integer[] expected_post = {1, 2, 4, 6, 8, 7, 5, 3};
        assertEquals(Arrays.asList(expected_post), toList(bst.travelPost()));
    }

    @Test
    public void BSTDeleteChildrenTest() throws Exception {
        BinarySearchTree<Integer> bst = setUpTree();
        bst.delete(5);

        Integer[] expected_pre = {3, 2, 1, 4, 7, 6, 9, 8};
        assertEquals(Arrays.asList(expected_pre), toList(bst.travelPre()));

        Integer[] expected_in = {1, 2, 3, 4, 6, 7, 8, 9};
        assertEquals(Arrays.asList(expected_in), toList(bst.travelIn()));

        Integer[] expected_post = {1, 2, 6, 8, 9, 7, 4, 3};
        assertEquals(Arrays.asList(expected_post), toList(bst.travelPost()));
    }
}
