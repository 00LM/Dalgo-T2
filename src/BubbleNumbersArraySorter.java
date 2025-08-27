import java.util.List;

/**
 * Implements the bubble sort algorithm for number arrays
 */
public class BubbleNumbersArraySorter implements NumbersArraySorter {

	@Override
	public void sort(List<Integer> numbers) {
		for (int i = 0; i < numbers.size()-1; i++) {
			for (int j = 0; j < numbers.size() - i - 1; j++) {
                if (numbers.get(j) > numbers.get(j + 1)) {
                    intercambiar(numbers, j, j + 1);
                }
            }
		}
	}
	
	public void intercambiar(List<Integer> numbers, int posI, int posJ) {
		int elemJ = numbers.get(posJ);
		int elemI = numbers.get(posI);
		numbers.set(posJ, elemI);
		numbers.set(posI, elemJ);
	}

}
