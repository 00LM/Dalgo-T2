import java.util.ArrayList;

public class DivideAndConquerIntegerArrays {

	// Array of numbers
	private ArrayList<Integer> numbers;

	/**
	 * Creates a new object with the given numbers
	 * @param numbers
	 */
	public DivideAndConquerIntegerArrays(ArrayList<Integer> numbers) {
		this.numbers = numbers;
	}
	
	/**
	 * Calculates the maximum value in this list
	 * @return int Maximum value in the list
	 */
	public int max() {
		return max(0, numbers.size()-1);
	}
	
	/**
	 * Calculates the maximum value within the given indexes
	 * @param first index
	 * @param last index
	 * @return int maximum value within the given limits
	 */
	private int max(int first, int last) {
		int mitad = (first+last)/2;
		
		if (first == last) return numbers.get(first);
		
		int maxDerecha = max(first,  mitad);
		int maxIzquierda = max(mitad+1,  last);
			
		if (maxIzquierda >= maxDerecha) {
	        return maxIzquierda;
	    } else {
	        return maxDerecha;
	    }
	}
	/**
	 * Finds a position in this numbers where the given value is located
	 * @param value to search
	 * @return int position where the given value is located
	 */
	public int searchUnsorted (int value) {
		return searchUnsorted (value, 0, numbers.size());
	}
	/**
	 * Finds a position in this numbers between the given limits where the given value is located
	 * @param value to search
	 * @param first index
	 * @param last index
	 * @return int position between first and last where the given value is located
	 */
	private int searchUnsorted (int value, int first, int last) {
		if (first > last) return -1;
		if (first == last && numbers.get(first) != value) return -1;
		int mitad = (first+last)/2;
		if (numbers.get(mitad) == value) {
			return mitad;
		}
		int izquierda = searchUnsorted(value, first, mitad - 1);
	    if (izquierda != -1) return izquierda;
	    return searchUnsorted(value, mitad + 1, last);
	}
	/**
	 * Finds a position in this numbers where the given value is located
	 * PRE: the numbers are sorted
	 * @param value to search
	 * @return int position where the given value is located
	 */
	public int searchSorted (int value) {
		return searchSorted(value, 0, numbers.size());
	}
	/**
	 * Finds a position in this numbers between the given limits where the given value is located
	 * PRE: the numbers are sorted
	 * @param value to search
	 * @param first index
	 * @param last index
	 * @return int position between first and last where the given value is located
	 */
	private int searchSorted (int value, int first, int last) {
		if(first>last) return -1;
		int mitad = (first+last)/2;
		int midInt = numbers.get(mitad);
		if(midInt == value) return mitad;
		if (value < midInt) {
			return searchSorted(value, first, mitad-1);
		}
		else return searchSorted(value, mitad+1, last);
	}
	
	/**
	 * Counts the number of even elements in this list of numbers
	 * @return int Number of values that are even
	 */
	public int countEven() {
		return countEven (0, numbers.size()-1);
	}
	
	/**
	 * Counts the number of even elements in this list of numbers between the given limits
	 * @param first index
	 * @param last index
	 * @return int count of even values within the given limits
	 */
	private int countEven (int first, int last) {
		int mitad = (first+last)/2;
		
		if (first == last) {
			if (numbers.get(first) % 2 == 0) return 1;
			else return 0;
		}
		
		int evenDerecha = countEven(first,  mitad);
		int evenIzquierda = countEven(mitad+1,  last);
		
		return evenDerecha + evenIzquierda;
	}
}
