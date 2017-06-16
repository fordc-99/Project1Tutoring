import java.util.ArrayList;

public class Stack<T> {
	
	protected ArrayList<T> elements;
	
	public Stack() {
		elements = new ArrayList<T>();
	}
	
	public boolean isEmpty() {
		return (elements.size() == 0);
	}
	
	public boolean isFull() {
		return false;
	}
	
	public void push(T element){
	  elements.add(element);
	}

	public void pop() throws StackUnderflowException{
	  if (isEmpty())
	    throw new StackUnderflowException("Pop attempted on empty stack.");
	  else
	    elements.remove(elements.size() - 1);
	}

	public T top() throws StackUnderflowException{
	  T topOfStack = null;
	  if (isEmpty())
	    throw new StackUnderflowException("Top attempted on empty stack.");
	  else
	    topOfStack = elements.get(elements.size() - 1);
	  return topOfStack;
	}

}
