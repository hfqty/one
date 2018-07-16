package me.ning.Sort;

import static me.ning.Sort.SortUtils.less;
import static me.ning.Sort.SortUtils.print;
import static me.ning.Sort.SortUtils.swap;

public class SelectionSort implements SortAlgorithm {


    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        int n = unsorted.length;
        for(int i = 0; i < n - 1; i++){
            int min = i;
            for(int j = i + 1; j< n; j++){
                if(less(unsorted[j],unsorted[min])){
                    min = j;
                }
            }

            if(min != i){
                swap(unsorted,i,min);
            }
        }
        return unsorted;
    }


    public static void main(String[] args) {
        Integer [] integers = {13,10,25,66,10,302,300,23,41,51,233,29,23};
        SelectionSort selectionSort = new SelectionSort();

        System.out.println("排序之前的数据：");
        print(integers);

        System.out.println("排序之后的数据：");
        print(selectionSort.sort(integers));


    }
}
