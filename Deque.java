public class Deque<Item>{

    private DblListNode<Item> _top;
    private DblListNode<Item> _end;
    private int _length;

    public Deque(){
	_top = null;
	_end = null;
    }

    public void addLeft(Item x){
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

    public void addRight(Item x){
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

    public Item removeLeft(){
	Item ans = _top.getValue();
	_length--;
	if (length() == 0)
	    _end = _top = null;
	else{
	    _top = _top.getNext();
	    _top.setPrevious(null);
	}
	return ans;
    }

    public Item removeRight(){
	Item ans = _end.getValue();
	if (_length > 1){
	    _end = _end.getPrevious();
	    _end.setNext(null);
	}
	else
	    _top = _end = null;
	_length--;
	return ans;
    }

    public boolean isEmpty(){
	return _top == null;
    }

    public int length(){
	return _length;
    }

    public Item getRight(){
	return _end.getValue();
    }

    public Item getLeft(){
	return _top.getValue();
    }

   public String toString(){
       String ans = "";
       DblListNode<Item> temp = _top;
       while (temp != null){
	   ans += temp.getValue() + ":"  + temp.getPrevious() + ":" + temp.getNext() + " ";
	   temp = temp.getNext();
       }
       return ans;
    }
    
    public static void main(String[] args){
	Deque<Integer> test = new Deque<Integer>();
	test.addLeft(1);
	test.addLeft(2);
	test.addRight(4);
	test.addLeft(2);
	System.out.println(test);
	System.out.println(test.removeRight());
	System.out.println(test.removeLeft());
	System.out.println(test.removeLeft());	
	System.out.println(test);
    }
}