public class LinkedListQueue<Item> implements Queue<Item>{

    private ListNode<Item> _top;
    private ListNode<Item> _end;

    public LinkedListQueue(){
	_top = null;
	_end = null;
    }

    public void enqueue(Item x){
	if (isEmpty()){
	    _top = new ListNode<Item>(x, null);
	    _end = _top;
	}
	else{
	    _end.setNext(new ListNode<Item>(x, null));
	    _end = _end.getNext();
	}
    }

    public Item dequeue(){
	Item ans = _top.getValue();
	_top = _top.getNext();
	if (_top == null)
	    _end = null;
	return ans;
    }

    public Item front(){
	return _top.getValue();
    }

    public boolean isEmpty(){
	return _top == null;
    }

    public String toString(){
       String ans = "";
       ListNode<Item> temp = _top;
       while (temp != null){
	   ans += temp.getValue() + " ";
	   temp = temp.getNext();
       }
       return ans;
    }

    public static void main(String[] args){
	Queue<Integer> test = new LinkedListQueue<Integer>();
	test.enqueue(1);
	test.enqueue(1);
	test.enqueue(1);
	System.out.println(test);

    }
}