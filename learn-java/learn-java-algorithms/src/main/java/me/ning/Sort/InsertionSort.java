package me.ning.Sort;

import static me.ning.Sort.SortUtils.less;
import static me.ning.Sort.SortUtils.print;

public class InsertionSort implements SortAlgorithm{
    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {

        for(int j = 1; j<unsorted.length;j++){

            T key = unsorted[j];

            int i = j -1;
            while(i>=0&& less(key,unsorted[i])){
                unsorted[i + 1] = unsorted[i];
                i --;
            }

            unsorted[i+1] = key;
        }
        return unsorted;
    }

    public static void main(String[] args) {
        Integer[]integers = {30,12,32,25,10,19,38,29,10,22,33};
        InsertionSort insertionSort = new InsertionSort();
        integers = insertionSort.sort(integers);
        print(integers);
    }

}
