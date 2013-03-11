public interface APList<Item>{

    boolean add(Item x);  // adds to the end
    Item get(int index);  // returns the item at the given index
    Item set(int index, Item newValue); // inserts newVale at index.
    // returns the old value 
					 
    int size(); // returns the number of items in the list

}