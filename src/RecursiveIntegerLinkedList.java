/**
 * Implementation of a linked list with recursive methods
 */
public class RecursiveIntegerLinkedList {

	//Number in this position of the list
	private int number;
	//Tells if this object represents an empty list
	private boolean empty;
	//Next element of the list. null if this is the last element of a list
	private RecursiveIntegerLinkedList next;
	//Last element of the list. It should only be used by the head of a list in the add method
	private RecursiveIntegerLinkedList last;
	
	/**
	 * Creates an empty list
	 */
	public RecursiveIntegerLinkedList () {
		next = last = null;
		empty = true;
	}
	/**
	 * Creates a list with the given value
	 * @param value to be added to the list
	 */
	public RecursiveIntegerLinkedList (int value) {
		number = value;
		next = null;
		last = this;
		empty = false;
	}
	/**
	 * Adds the value at the end of the current list
	 * @param value to be added at the end
	 */
	public void add (int value) {
		if(empty) {
			number = value;
			last = this;
			empty= false;
		} else {
			RecursiveIntegerLinkedList newLast = new RecursiveIntegerLinkedList(value);
			last.next = newLast;
			last = newLast;
		}
	}
	
	/**
	 * Returns the element in the current position of the list
	 * @param pos position in the list
	 * @return int the value present at the given position.
	 * @throws ArrayIndexOutOfBoundsException if the given position is invalid
	 */
	public int get (int pos) {
		if(empty) throw new ArrayIndexOutOfBoundsException("Get can not be used on an empty list");
		if(next == null) throw new ArrayIndexOutOfBoundsException("Invalid argument for get: "+pos);
		if(pos ==0) return number;
		return next.get(pos-1);
	}
	/**
	 * Calculates the size of the list
	 * @return int Size of the list
	 */
	public int size () {
		if (next == null) {
			return 1;
		}
		else if (empty) {
			return 0;
		}
		else {
			return 1+next.size();
		}
		
	}
	
	/**
	 * Returns the index of the first appearance of the given value
	 * @param value to be searched
	 * @return int position of the list whare the value is located
	 */
	public int indexOf(int value) {
		if (next == null | empty) {
			return -1;
		}
		else if (number == value) {
			return 0;
		}
		return 1 + next.indexOf(value);
	}
	
	/**
	 * Returns the index of the last appearance of the given value
	 * @param value to be searched
	 * @return int position of the list whare the value is located
	 */
	public int lastIndexOf(int value) {
		if (empty) {
	        return -1;
	    }
	    if (next == null) {
	        if (number == value) return 0;
	        else return -1;
	    }
	    int temp = next.lastIndexOf(value);
	    if (temp == -1) {
	        if (number == value) return 0;
	        else return -1;
	    }
	    return 1 + temp;

	}
	
	/**
	 * Calculates the maximum value in the list
	 * @return int Maximum value
	 */
	public int max () {
		if (empty) {
	        return -1;
	    }
		else if (next == null) {
			return number;
		}
		
		int max = next.max(); 
	    if (number > max) {
	        return number;
	    } else {
	        return max;
	    }
	}
	
	/**
	 * Counts the number of even elements in the list
	 * @return int Number of values that are even
	 */
	public int countEven () {
		if (empty) return 0;
		else if (next == null) {
			if (number % 2 == 0) return 1;
			else return 0; 
		}
		else {
			if (number % 2 == 0) return 1 + next.countEven();
			else return next.countEven();
		}
	}
	
	/**
	 * Tells if the list is sorted
	 * @return boolean if the list is sorted by value. False otherwise
	 */
	public boolean isSorted () {
		if (empty) {
			return true;
		}
		else if (next == null) {
			return true;
		}
		return (number <= next.number && next.isSorted());
	}
}
