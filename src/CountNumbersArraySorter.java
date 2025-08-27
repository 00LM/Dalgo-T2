import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Implements the bubble sort algorithm for number arrays
 */
public class CountNumbersArraySorter implements NumbersArraySorter {

	@Override
	public void sort(List<Integer> numbers) {
		if (numbers.isEmpty()) return;
		
		int max = -1;
		for (int i = 0; i < numbers.size(); i++) {
			if (numbers.get(i) > max) {
				max = numbers.get(i);
			}
		}
		
		ArrayList<Integer> lista = new ArrayList<Integer>(Collections.nCopies(max+1, 0));
		
		for (int i = 0; i < numbers.size(); i++) {
			int prev = numbers.get(i);
			lista.set(prev, lista.get(prev) + 1);
		}
		
		for (int i = 1; i <= max; i++) { //paar que cuadren los indices een al resultante
			int prev = lista.get(i-1);
			lista.set(i, lista.get(i)+prev);
		}
		
		int[] salida = new int[numbers.size()];
	    for (int i = numbers.size() - 1; i >= 0; i--) {
	        int val = numbers.get(i);
	        int pos = lista.get(val) - 1; 
	        salida[pos] = val;
	        lista.set(val, lista.get(val) - 1); //para nums repetidos, para acabar posicionamiento de ese num part. 
	    }
	    
	    for (int i = 0; i < numbers.size(); i++) {
	        numbers.set(i, salida[i]);
	    }
	
	}
	

}
