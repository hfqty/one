package me.ning.Sort;

import static me.ning.Sort.SortUtils.less;
import static me.ning.Sort.SortUtils.print;
import static me.ning.Sort.SortUtils.swap;

public class BubbleSort implements SortAlgotithm{

    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        int last = unsorted.length;

        boolean swap ;
        do{
            swap = false;
            int count = 0;
            do{
                if(less(unsorted[count],unsorted[count+1])){
                    swap = swap(unsorted,count,count+1);
                }
                count++;
            }while(count<last-1);
            last --;
        }while(swap);

        return unsorted;
    }

    public static void main(String[]args){

        Integer[] integers  = {19,2,13,49,123,4182,122,449,5,12,591,2,34,1,100};
        BubbleSort bubbleSort = new BubbleSort();
        integers = bubbleSort.sort(integers);
        print(integers);


    }
}
