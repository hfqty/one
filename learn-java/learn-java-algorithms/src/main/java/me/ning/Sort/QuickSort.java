package me.ning.Sort;

import java.util.List;

import static me.ning.Sort.SortUtils.less;
import static me.ning.Sort.SortUtils.print;
import static me.ning.Sort.SortUtils.swap;
import static me.ning.UI.InputUtil.integerList;
import static me.ning.UI.InputUtil.stringList;

public class QuickSort implements SortAlgorithm {
    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        doSort(unsorted,0,unsorted.length-1);
        return unsorted;
    }

    private static <T extends Comparable<T>> void doSort(T[] array,int left,int right){

        if(left<right){
            int pivot = partition(array,left,right);
            doSort(array,left,pivot - 1);
            doSort(array,pivot,right);
        }
    }


    private static <T extends Comparable<T>> int partition(T[] array,int left,int right){

        int mid = (left + right )/2;
        T pivot = array[mid];

        while (left <= right) {
            while(less(array[left],pivot)){
                ++ left;
            }
            while(less(pivot,array[right])){
                -- right;
            }
            if(left <= right){
                swap(array,left,right);
                ++left;
                --right;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        List<Integer> integers = integerList(10);
        QuickSort quickSort = new QuickSort();

        System.out.println("排序之前的数据：");
        print(integers);

        System.out.println("排序之后的数据：");
        print(quickSort.sort(integers));

        List<String> strings = stringList(10);
        System.out.println("排序之前的数据：");
        print(strings);
        System.out.println("排序之后的数据：");
        print(quickSort.sort(strings));
    }
}
