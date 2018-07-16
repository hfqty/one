package me.ning.Sort;

import static me.ning.Sort.SortUtils.less;
import static me.ning.Sort.SortUtils.print;
import static me.ning.Sort.SortUtils.swap;

public class ShellSort implements SortAlgorithm {
    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        int size = unsorted.length;
        int h = 1;

        while(h<size/3){
            h = 3*h +1;
        }

        while(h>= 1){
            for(int i = h; i <size;i++){
                for (int j = i; j>= h && less(unsorted[j],unsorted[j-h]);j -= h){
                    swap(unsorted,j,j-h);
                }
            }
            h/=3;
        }
        return unsorted;
    }

    /**
     * other version
     * 其他版本的排序方式
     */
    private static Integer[] shellSort(Integer[]arr){
        int gap = 1,i,j,len=arr.length;
        int temp;
        while(gap < len/3){
            gap = gap * 3+1;
        }
        for(;gap>0;gap/=3){
            for(i = gap;i<len;i++){
                temp = arr[i];
                for(j=i-gap;j>=0&&arr[j]>temp;j-=gap){
                    arr[j+gap] = arr[j];
                }
                arr[j+gap] = temp;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        Integer[] toSort = {100,213,80,30,102,0,21,23,20,1,10};
        ShellSort shellSort = new ShellSort();

        System.out.println("排序之前的数据：");
        print(toSort);

        System.out.println("排序之后的数据：");
      //  print(shellSort.sort(toSort));

        print(shellSort(toSort));
    }
}
