package me.ning.Sort;

import static me.ning.Sort.SortUtils.less;
import static me.ning.Sort.SortUtils.print;
import static me.ning.Sort.SortUtils.swap;

public class CombSort implements SortAlgorithm {


    private int nextGap(int gap){
        gap = (gap*10)/13;
        return gap<1?1:gap;
    }
    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
       int size = unsorted.length;

       int gap = size;

       boolean swap= true;

       while(gap != 1 || swap){
           gap = nextGap(gap);

           swap = false;

           for(int i = 0; i < size - gap; i++){
               if(less(unsorted[i+gap],unsorted[i])){
                   swap = swap(unsorted,i,i+gap);
               }
           }
       }
       return unsorted;
    }


    public static void main(String[]args){
        SortAlgorithm combSort = new CombSort();
        Integer []integers = {10,4,1000,33,199,12,133,45,30,10};
        integers = combSort.sort(integers);
        print(integers);

        String [] strings = {"b","sd","f","h","g","u","i","o","p","q","r","s"};
        strings = combSort.sort(strings);
        print(strings);

    }

}
