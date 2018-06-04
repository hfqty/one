package me.ning.Sort;

import static me.ning.Sort.SortUtils.less;
import static me.ning.Sort.SortUtils.print;
import static me.ning.Sort.SortUtils.swap;

public class CocktailShakerSort implements SortAlgorithm {
    @Override
    public <T extends Comparable<T>> T[] sort(T[] unsorted) {
        int last = unsorted.length;

        boolean swap;

        do {
            swap = false;

            int count = 0;
            do {
                if (less(unsorted[count + 1], unsorted[count])) {
                    swap = swap(unsorted, count, count + 1);
                }


                count++;
            } while (count <= last - 2);

            if (!swap)
                break;
            swap = false;

            count = last - 2;

            do {
                if (less(unsorted[count + 1], unsorted[count])) {
                    swap = swap(unsorted, count, count + 1);
                }
                count--;
            } while (count > 0);


            last--;
        } while (swap);
        return unsorted;
    }

    public static void main(String[] args) {
        Integer[] integers = {100, 10, 30, 20, 40, 20, 50, 70, 100, 90, 60, 10};
        SortAlgorithm shakerSort = new CocktailShakerSort();
        integers = shakerSort.sort(integers);
        print(integers);

        String [] strs = {"我","说","我","不","呢","你","我","s"};
        strs = shakerSort.sort(strs);
        print(strs);
    }
}
