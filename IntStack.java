import java.util.*;

public class IntStack{

    private LinkListStack<Integer> _mainStack, _min;

    public IntStack(){
	_mainStack = new LinkListStack<Integer>();
	_min = new LinkListStack<Integer>();
    }

    public void push(int x){
	_mainStack.push(x);
	if (_min.isEmpty())
	    _min.push(x);
	else{
	    if (x <= _min.peek()){
		_min.push(x);
	    }    
	}
    }

    public int pop(){
	int ans = _mainStack.pop();
	if (ans == _min.peek())
	    _min.pop();
	return ans;
    }

    public boolean isEmpty(){
	return _mainStack.isEmpty();
    }

    public int peek(){
	return _mainStack.peek();
    }

    public int getMin(){
	return _min.peek();
    }

    public String toString(){
	return _mainStack.toString();
    }

    public static ListNode<Integer> reverse(ListNode<Integer> node){
	ArrayList<ListNode<Integer>> stor = new ArrayList<ListNode<Integer>>();
	ListNode<Integer> temp = node;
	while (temp != null){
	    stor.add(temp);
	    temp = temp.getNext();
	}
	int i = stor.size()-1;
	node = stor.get(i);
	while (i > 0){
	    stor.get(i).setNext(stor.get(i-1));
	    i--;
	}
	stor.get(0).setNext(null);
	return node;
    }

    public static ListNode<Integer> reverse2(ListNode<Integer> node){
	ListNode<Integer> walker = node;
	ListNode<Integer> previous = null;
	while (walker != null){
	    if (walker == node){
		previous = walker;
		walker = walker.setNext(null);
	    }
	    else{
		ListNode<Integer> temp = walker;
		walker = walker.setNext(previous);
		previous = temp;
	    }
	}
	node = previous;
	return node;
    }

    public static ListNode<Integer> reverse3(ListNode<Integer> node){
	LinkListStack<ListNode<Integer>> stack = 
	    new LinkListStack<ListNode<Integer>>();
	ListNode<Integer> walker = node;
	while (walker.getNext() != null){
	    stack.push(walker);
	    walker = walker.getNext();
	}
	stack.push(walker);
	node = stack.peek();
	ListNode<Integer> temp;
	while (!stack.isEmpty()){
	    temp = stack.pop();
	    if (stack.isEmpty())
		temp.setNext(null);
	    else
		temp.setNext(stack.peek());
	}
	return node;
    }

    public static void main(String[] args){
	// IntStack test = new IntStack();
	// test.push(5);
	// test.push(2);
	// test.push(3);
	// test.push(2);
	// System.out.println(test);
	// System.out.println(test.getMin());
	// test.pop();
	// System.out.println(test);
	// System.out.println(test.getMin());
	ListNode<Integer> five = new ListNode<Integer>(5, null);
	ListNode<Integer> four = new ListNode<Integer>(4, five);
	ListNode<Integer> three = new ListNode<Integer>(3, four);
	ListNode<Integer> two = new ListNode<Integer>(2, three);
	ListNode<Integer> one = new ListNode<Integer>(1, two);
	System.out.println(reverse3(one));
	//System.out.println(reverse2(one));
	String ans = "";
	ListNode<Integer> temp = five;
	while (temp != null){
	    ans += temp + " ";
	    temp = temp.getNext();
	}
	System.out.println(ans);
    }
}