public class CircularLinkedList<Item> implements APList<Item>{

    private DblListNode<Item> _top;
    private int _length;

    public CircularLinkedList(){
	_top = null;
	_length = 0;
    }

    public DblListNode<Item> getTop(){
	return _top;
    }

    public DblListNode<Item> setTop(DblListNode<Item> x){
	DblListNode<Item> ans = _top;
	_top = x;
	return _top;
    }

    //adds to the end
    //O(1)
    public boolean add(Item x){ 
	if (size() == 0){ //If size is 0, you need to do different stuff
	    _top = new DblListNode<Item>(x, null, null);
	    _top.setNext(_top); //Must set reference after or _top is still null
	    _top.setPrevious(_top); 
	}
	else{
	    DblListNode<Item> temp = _top.getPrevious(); //Previous "last" item
	    _top.setPrevious(new DblListNode<Item>(x, temp, _top)); //New node
	    temp.setNext(_top.getPrevious()); //No longer the last item
	 }
	_length++;
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

    public void dec(){
	_length--;
    }
    
    //O(n)
    // inserts newVale at index. returns the old value 
    public Item set(int index, Item newValue){ //Just changes the value of the node
	DblListNode<Item> temp = this.getNode(index);
	return temp.setValue(newValue);
    }

    public int size(){ //Copied from deque
	return _length;
    }

    //O(n)
    public String toString(){ //Copied from deque
	String ans = "";
	DblListNode<Item> temp = _top;
	int tempSize = 0;
	while (tempSize < size()){
	    ans += temp.getValue() + ":" + temp.getPrevious() + 
		":" + temp.getNext() +  " ";
	    temp = temp.getNext();
	    tempSize++;
	}
	return ans;
    }

    public static void main(String[] args){
	CircularLinkedList<Integer> x = new CircularLinkedList<Integer>();
	System.out.println(x);
	x.add(1);
	//System.out.println(x._top);
	System.out.println(x);
	x.add(2);
	System.out.println(x);
	 x.add(4);
	// x.add(7);
	// x.set(0, 7);
	 System.out.println(x);
    }
}