
public class ListNode<Item>{
    
    private Item _value;
    private ListNode<Item> _next;

    public ListNode(Item value){
	_value = value;
	_next = null;
    }

    public ListNode(Item value, ListNode<Item> next){
	this(value);
	_next = next;
    }

    public Item getValue(){
	return _value;
    }

    public ListNode<Item> getNext(){
	return _next;
    }

    public Item setValue(Item x){
	Item temp = _value;
	_value = x;
	return temp;
    }

    public String toString(){
	return _value + " ";
    }

    public ListNode<Item> setNext(ListNode<Item> x){
	ListNode<Item> temp = _next;
	_next = x;
	return temp;
    }
    
}
