public interface Stack<Item>{

    public void push(Item x);
    
    public Item pop();
    
    public Item peek();

    public boolean isEmpty();

}