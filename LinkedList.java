//Sweyn Venderbush
//Mr. Platek P1 APCS
//*************************LinkedList*************************

import java.util.Iterator;
import java.util.ArrayList;

public class LinkedList<Item> implements APList<Item>{

    private DblListNode<Item> _top, _end;
    private int _length;
    
    public LinkedList(){
	_top = _end = null;
	_length = 0;
    }
    
    // adds to the end
    //O(1)
    public boolean add(Item x){ //You need this to fulfill the list implementation
	addRight(x);
	return true; //Always returns true
    }  

    // returns the item at the given index
    //O(n)
    public Item get(int index){
	return getNode(index).getValue(); //Use the getNode function to return value
    }  

    //O(n)
    public DblListNode<Item> getNode(int index){ //I use this for a bunch of things
	DblListNode<Item> temp = _top;
	while (index > 0){
	    temp = temp.getNext();
	    index--;
	}
	return temp; //Returns the actual node instead of the value of the node
    }  
    
    //O(n)
    // inserts newVale at index. returns the old value 
    public Item set(int index, Item newValue){ //Just changes the value of the node
	DblListNode<Item> temp = this.getNode(index);
	return temp.setValue(newValue);
	
    }
    
    //O(1)
    public void addLeft(Item x){ //Copied from deque
	if (isEmpty()){
	    _top = new DblListNode<Item>(x, null, null);
	    _end = _top;
	}
	else{
	    DblListNode<Item> temp = _top;
	    _top = new DblListNode<Item>(x, null, _top);
	    temp.setPrevious(_top);
	}
	_length++;
    }

    //O(1)
    public void addRight(Item x){ //Copied from deque
	if (isEmpty()){
	    _top = new DblListNode<Item>(x, null, null);
	    _end = _top;
	}
	else{
	    _end.setNext(new DblListNode<Item>(x, _end, null));
	    _end = _end.getNext();
	}
	_length++;
    }

    //O(1)
    public Item removeLeft(){ //Copied from deque
	Item ans = _top.getValue();
	_length--;
	if (size() == 0)
	    _end = _top = null;
	else{
	    _top = _top.getNext();
	    _top.setPrevious(null);
	}
	return ans;
    }

    //O(1)
    public Item removeRight(){ //Copied from deque
	Item ans = _end.getValue();
	if (size() > 1){
	    _end = _end.getPrevious();
	    _end.setNext(null);
	}
	else
	    _top = _end = null;
	_length--;
	return ans;
    }

    //O(1)
    public boolean isEmpty(){ //Copied from deque
	return _top == null;
    }

    //O(1)
    public int size(){ //Copied from deque
	return _length;
    }

    //O(1)
    public Item getRight(){ //Copied from deque
	return _end.getValue();
    }

    //O(1)
    public Item getLeft(){ //Copied from deque
	return _top.getValue();
    }

    //O(n)
    // returns true if x is in the list. false otherwise
    public boolean find(Item x){
	boolean ans = false;
	DblListNode<Item> temp = _top;
	while (temp.getNext() != null){ //Walks through nodes like before
	    if (temp.getValue() == x){ //If it find the value, break and return true
		ans = true;
		break;
	    }
	    temp = temp.getNext();
	}
	return ans;
    } 

    // deletes and returns the kth item in the list. 0 <= k < size()
    //O(n)
    public Item delete(int k){
	DblListNode<Item> temp = getNode(k); //Gets the node you want to delete
	DblListNode<Item> before = temp.getPrevious(); //Gets the one before
	DblListNode<Item> after = temp.getNext(); //Gets the one after
	if (after != null) //Check if you are deleting the last element
	    after.setPrevious(before); //Cuts out the reference to the deleted node
	else
	    _end = before; //If the element is the end node, the _end changes
	if (before != null) //Check if you are deleting the first element
	    before.setNext(after); //Cuts out the reference to the deleted node
	else
	    _top = after; //Cuts out the reference to the deleted node
	_length--; 
	return temp.getValue();
    }

    //O(n)
    public String toString(){ //Copied from deque
	String ans = "";
	DblListNode<Item> temp = _top;
	while (temp != null){
	    ans += temp.getValue() + ":" + temp.getPrevious() + 
		":" + temp.getNext() +  " ";
	    temp = temp.getNext();
	}
	return ans;
    }

    public Iterator<Item> iterator(){
	return new MyIterator();
    }

    public class MyIterator implements Iterator<Item>{

	private ArrayList<Integer> done;
	private Integer next;

	public MyIterator(){
	    done = new ArrayList<Integer>();
	    next = 0;
	}

	public boolean hasNext(){
	    return _length != done.size();
	}

	public Item next(){
	    DblListNode<Item> temp = _top;
	    Integer rand = (int)(Math.random() * _length);
	    while (done.contains(rand)){
		rand = (int)(Math.random() * _length);
	    }
	    done.add(rand);
	    next = rand;
	    return get(next);
	}

	public void remove(){
	    delete(next);
	}
    }
    
    public static void main(String[] args){
	LinkedList<Integer> x = new LinkedList<Integer>();
	System.out.println(x);
	x.add(1);
	x.add(2);
	x.addRight(4);
	x.addRight(7);
	System.out.println(x);
	for (int temp: x)
	    System.out.println(temp);
    }

}
