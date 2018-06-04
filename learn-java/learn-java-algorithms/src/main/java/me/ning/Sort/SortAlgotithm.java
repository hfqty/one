package me.ning.Sort;

import java.util.Arrays;
import java.util.List;

public interface SortAlgotithm {

    <T extends Comparable<T>> T[] sort(T[] unsorted);

    default <T extends Comparable<T>>List<T> sort(List<T> unsort){
        return Arrays.asList(sort(unsort.toArray((T[])new Comparable[unsort.size()])));
    }
}
