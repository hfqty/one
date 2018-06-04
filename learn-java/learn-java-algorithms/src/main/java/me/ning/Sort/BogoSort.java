package me.ning.Sort;

import java.util.Random;

import static me.ning.Sort.SortUtils.less;
import static me.ning.Sort.SortUtils.print;
import static me.ning.Sort.SortUtils.swap;

public class BogoSort implements SortAlgotithm{

    private static final Random random = new Random();

    private static <T extends Comparable<T>> boolean isSorted(T array[]){
        for(int i=0; i <array.length-1;i ++){
            if(less(array[i+1],array[i])) return false;

        }
        return true;
    }

    private static <T> void nextPermutation(T array[]){
        int length = array.length;

        for(int i =0; i<array.length;i++){
            int randomIndex = i + random.nextInt(length - 1);
            swap(array,randomIndex,i);
        }
    }

    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        while(!isSorted(unsorted)){
            nextPermutation(unsorted);
        }
        return unsorted;
    }

    public static void main(String[] args) {
        Integer[] integers = {19,3,49,192,23,3213,49,12,1992,12};
        BogoSort bogoSort = new BogoSort();
        integers = bogoSort.sort(integers);
        print(integers);
    }
}
