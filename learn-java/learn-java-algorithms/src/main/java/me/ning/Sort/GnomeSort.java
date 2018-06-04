package me.ning.Sort;

import static me.ning.Sort.SortUtils.less;
import static me.ning.Sort.SortUtils.print;
import static me.ning.Sort.SortUtils.swap;

public class GnomeSort implements SortAlgorithm {
    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        int i = 1;
        int j = 2;
        while(i<unsorted.length){
            if(less(unsorted[i-1],unsorted[i])){
                i = j++;
            }
            else{
                swap(unsorted,i-1,i);
                if(--i==0){
                    i=j++;
                }
            }
        }
        return unsorted;
    }

    public static void main(String[]args){
        Integer[] integers = {10,30,20,11,18,19,123,12,10,4,50,12,123,22};
        String[]strings = {"j","s","a","z","x","h","j","i","o","p","x","z"};
        GnomeSort gnomeSort = new GnomeSort();
        gnomeSort.sort(integers);
        gnomeSort.sort(strings);
        System.out.println("排序之后的数据：");
        print(integers);
        print(strings);

    }
}
