import java.util.*;

interface Queue<Item> extends Iterable<Item>{

    public void enqueue(Item x);

    public Item dequeue();

    public Item front();

    public boolean isEmpty();

    Iterator<Item> iterator();

}