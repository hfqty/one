package me.ning.Sort;

import static me.ning.Sort.SortUtils.less;
import static me.ning.Sort.SortUtils.print;

public class CycleSort implements SortAlgorithm {
    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        int n = unsorted.length;

        for(int j = 0; j<=n - 2;j++){
            T item = unsorted[j];
            int pos = j;

            for(int i = j +1; i<n; i++)
                if(less(unsorted[i],item))pos++;

                if(pos == j){
                    continue;
                }
                while(item.compareTo(unsorted[pos]) == 0)
                    pos +=1;
                if(pos != j)
                    item = replace(unsorted,pos,item);

                while(pos != j){
                    pos = j;
                    for(int i=j+1; i < n ; i++){
                        if(less(unsorted[i],item)){
                            pos++;
                        }
                    }
                    while(item.compareTo(unsorted[pos]) == 0){
                        pos ++;
                    }

                    if(item != unsorted[pos]){
                        item = replace(unsorted,pos,item);
                    }
                }

        }
        return unsorted;
    }

    private <T extends Comparable<T>> T replace (T[] arr,int pos,T item){
        T temp = item;
        item = arr[pos];
        arr[pos] = temp;
        return item;
    }

    public static void main(String[] args) {
        Integer arr[] = {100,30,30,20,200,300,230,10,400,50,300,100,80};
        CycleSort cycleSort = new CycleSort();

        System.out.println("排序之前的数据：");
        print(arr);
        System.out.println("排序之后的数据：");
        arr = cycleSort.sort(arr);
        print(arr);
    }


}
