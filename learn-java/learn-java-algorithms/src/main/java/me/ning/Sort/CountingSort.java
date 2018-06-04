package me.ning.Sort;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;
import static me.ning.Sort.SortUtils.print;


public class CountingSort implements SortAlgotithm {
    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        return sort(Arrays.asList(unsorted)).toArray(unsorted);
    }

    @Override
    public <T extends Comparable<T>> List<T> sort(List<T> unsort) {
        Map<T,Integer> frequency = new TreeMap<>();
        List<T> sortedArray = new ArrayList<>(unsort.size());
        unsort.forEach(t -> frequency.put(t,frequency.getOrDefault(t,0)+1));
        for (Map.Entry<T,Integer> ele : frequency.entrySet()){
            for(int j = 0; j<ele.getValue();j++){
                sortedArray.add(ele.getKey());
            }
        }
        return sortedArray;
    }

    private static <T extends Comparable<T>> List<T> streamSort(List<T> list){
   return list.stream()
           .collect(toMap(k -> k, v -> 1, (v1, v2) -> v1 + v2, TreeMap::new))
           .entrySet()
           .stream()
           .flatMap(entry-> IntStream.rangeClosed(1,entry.getValue()).mapToObj(t->entry.getKey()))
           .collect(Collectors.toList());

    }

    public static void main(String[] args) {
        List<Integer> unsortedInts = Stream.of(10,4,55,33,10,20,40,13,41,31).collect(Collectors.toList());
        CountingSort countingSort = new CountingSort();

        System.out.println("排序之前的数据：");
        print(unsortedInts);

        System.out.println("排序之后的数据：");
        print(countingSort.sort(unsortedInts));

        System.out.println("使用stream排序之后的数据：");
        print(streamSort(unsortedInts));

        List<String> unsortStrs = Stream.of("u","r","q","y","s","x","n","x","z","m","n","z","a","w")
                .collect(Collectors.toList());
        System.out.println("排序之前的数据：");
        print(unsortStrs);

        System.out.println("排序之后的数据：");
        print(countingSort.sort(unsortStrs));

        System.out.println("使用stream排序之后的数据");
        print(streamSort(unsortStrs));


    }
}
