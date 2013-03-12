public class JosephsCult{

    public static String JosephsCult(CircularLinkedList<String> x, int k){
	String ans = "";
	DblListNode<String> temp = x.getTop().getPrevious();
	while (x.size() > 1){
	    for (int i = 0; i < k; i++)
		temp = temp.getNext();
	    ans += temp.getValue() + " ";
	    DblListNode<String> before = temp.getPrevious();
	    DblListNode<String> after = temp.getNext();
	    after.setPrevious(before);
	    before.setNext(after);
	    if (temp == x.getTop())
		x.setTop(temp.getNext());
	    x.dec();
	}
	return ans + "| " + x.getTop() + " survives!";	
    }

    public static void main(String[] args){
	CircularLinkedList<String> input = new CircularLinkedList<String>();
	input.add("Bob");
	input.add("Sally");
	input.add("Abe");
	input.add("Jane");
	input.add("Bill");
	input.add("Ted");
	System.out.println(JosephsCult(input, 3));
    }

}