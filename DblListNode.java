
public class DblListNode<Item>{
    
    private Item _value;
    private DblListNode<Item> _next, _previous;

    public DblListNode(Item value){
	_value = value;
	_next = null;
	_previous = null;
    }

    public DblListNode(Item value, DblListNode<Item> previous, 
		       DblListNode<Item> next){
	this(value);
	_next = next;
	_previous = previous;
    }

    public Item setValue(Item x){
	Item temp = _value;
	_value = x;
	return temp;
    }

    public DblListNode<Item> setNext(DblListNode<Item> x){
	DblListNode<Item> temp = _next;
	_next = x;
	return temp;
    }
    
    public DblListNode<Item> setPrevious(DblListNode<Item> x){
	DblListNode<Item> temp = _previous;
	_previous = x;
	return temp;
    }

    public DblListNode<Item> getNext(){
	return _next;
    }

    public DblListNode<Item> getPrevious(){
	return _previous;
    }

    public Item getValue(){
	return _value;
    }

    public String toString(){
	return _value + "";
    }
}
