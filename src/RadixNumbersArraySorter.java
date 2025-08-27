import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Implements the bubble sort algorithm for number arrays
 */
public class RadixNumbersArraySorter implements NumbersArraySorter {

	@Override
	public void sort(List<Integer> numbers) {
		if (numbers.isEmpty()) return;
		
		int max = -1;
		for (int i = 0; i < numbers.size(); i++) {
			if (numbers.get(i) > max) {
				max = numbers.get(i);
			}
		}

		int digitos = (int) Math.log10(max) + 1;

        for (int d = 0; d < digitos; d++) {
        	sort2(numbers, d);
        }
	}
		
	public void sort2(List<Integer> numbers, int d) { //modif dee count con el mod para iterar sobre los dígitos
		int n = numbers.size();
        int[] salida = new int[n];
        ArrayList<Integer> lista = new ArrayList<>(Collections.nCopies(10, 0));

        for (int i = 0; i < n; i++) {
            int num = numbers.get(i);
            int digito = (num / (int)Math.pow(10, d)) % 10; 
            lista.set(digito, lista.get(digito) + 1);
        }

        for (int i = 1; i < 10; i++) {
            lista.set(i, lista.get(i) + lista.get(i - 1));
        }

        for (int i = n - 1; i >= 0; i--) {
            int num = numbers.get(i);
            int digito = (num / (int)Math.pow(10, d)) % 10;
            int pos = lista.get(digito) - 1;
            salida[pos] = num;
            lista.set(digito, lista.get(digito) - 1);
        }

        for (int i = 0; i < n; i++) {
            numbers.set(i, salida[i]);
        }
	
	}
	

}
