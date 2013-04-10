import java.util.ArrayList;
import java.util.*;

public class ArrayListQueue<Item> implements Queue<Item>{
    
    private ArrayList<Item> _queue;

    public ArrayListQueue(){
	_queue = new ArrayList<Item>();
    }

    public void enqueue(Item x){
	_queue.add(x);
    }

    public Item dequeue(){
	return _queue.remove(0);
    }

    public Item front(){
	return _queue.get(0);
    }

    public boolean isEmpty(){
	return _queue.size() == 0;
    }

    public String toString(){
	String ans = "";
	for (int i = 0; i < _queue.size(); i++)
	    ans += _queue.get(i) + " ";
	return ans;
    }

    public Iterator<Item> iterator(){
	return new MyIterator();
    }

    public class MyIterator extends Iterator<Item>{
	
	public boolean hasNext(){
	    return !isEmpty();
	}

	public Item next(){
	    dequeue();
	}

	public void remove(){}
    }
}