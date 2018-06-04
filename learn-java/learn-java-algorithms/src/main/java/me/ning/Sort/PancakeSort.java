package me.ning.Sort;

import static me.ning.Sort.SortUtils.flip;
import static me.ning.Sort.SortUtils.less;
import static me.ning.Sort.SortUtils.print;

public class PancakeSort implements SortAlgorithm {
    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        int size = unsorted.length;

        for(int i = 0; i < size; i ++){
            T max = unsorted[0];
            int index = 0;
            for(int j = 0; j < size - i;j++){
                if(less(max,unsorted[j])){
                    max = unsorted[j];
                    index = j;
                }
            }
            flip(unsorted,index,unsorted.length-1-i);
        }
        return unsorted;
    }

    public static void main(String[]args){
        Integer [] integers = {10,100,20,300,40,-40,-33,-60,-10,102,-90,-123,-23};
        PancakeSort pancakeSort = new PancakeSort();
        System.out.println("排序后的数据：");
        print(pancakeSort.sort(integers));
    }
}
