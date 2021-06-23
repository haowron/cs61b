package lectures.trees;

import java.util.Iterator;

public interface iBST<Item extends Comparable<Item>> {
    public Item insert(Item x) throws Exception;

    public Item delete(Item x) throws Exception;

    public Item find(Item x);

    public Iterator<Item> travelPre();

    public Iterator<Item> travelIn();

    public Iterator<Item> travelPost();

    public String toString();
}
