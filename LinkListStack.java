public class LinkListStack<Item> implements Stack<Item>{
    
    private ListNode<Item> _top;

    public LinkListStack(){
	_top = null;
    }

    public void push(Item x){
	_top = new ListNode<Item>(x, _top);
    }

    public Item pop(){
	Item ans = _top.getValue();
	_top = _top.getNext();
	return ans;
    }

    public Item peek(){
	return _top.getValue();
    }

    public boolean isEmpty(){
	return _top == null;
    }

    public String toString(){
	String ans = "";
	ListNode<Item> temp = _top;
	while (temp != null){
	    System.out.println(temp);
	    temp = temp.getNext();
	}
	return ans;
    }
    
}