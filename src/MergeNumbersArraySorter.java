import java.util.ArrayList;
import java.util.List;

/**
 * Implements the merge sort algorithm for number arrays
 */
public class MergeNumbersArraySorter implements NumbersArraySorter {

	@Override
	public void sort(List<Integer> numbers) {
		mergeSort(numbers, 0, numbers.size()-1);
	}
	
	public void mergeSort(List<Integer> numbers,  int first, int last) {
		if(first>=last) return;
		int mitad = (first+last)/2;
		mergeSort(numbers, first, mitad);
		mergeSort(numbers, mitad+1, last);
		mergeSortedLists(numbers, first, mitad, last);
	}
	
	public void mergeSortedLists(List<Integer> numbers, int first, int mitad, int last) {
		List<Integer> mergedLists = new ArrayList<>();
		int i = first;
		int j = mitad+1;
		while (i <= mitad && j <= last) {
			int i1 = numbers.get(i);
			int i2 = numbers.get(j);
			if (i1 <= i2) {
				mergedLists.add(i1);
				i++;
			}
			else {
				mergedLists.add(i2);
				j++;
			}
		}
		for(;i<=mitad;i++) mergedLists.add(numbers.get(i));
		for(;j<=last;j++) mergedLists.add(numbers.get(j));
		for(int k=0;k<mergedLists.size();k++) {
			numbers.set(first+k,mergedLists.get(k));
		}
	}

}
